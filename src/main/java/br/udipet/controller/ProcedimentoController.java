package br.udipet.controller;

import br.udipet.dto.ProcedimentoDTO;
import br.udipet.entity.Procedimento;
import br.udipet.repository.PlanoRepository;
import br.udipet.repository.ClinicaRepository;
import br.udipet.repository.ProcedimentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/procedimento")
public class ProcedimentoController {
    private ProcedimentoRepository ProcedimentoRepository;
    private ClinicaRepository ClinicaRepository;
    private PlanoRepository PlanoRepository;
    final Path rootDir;
	
	@Autowired
    public ProcedimentoController(ProcedimentoRepository ProcedimentoRepository, ClinicaRepository ClinicaRepository, PlanoRepository PlanoRepository) {
        this.ProcedimentoRepository = ProcedimentoRepository;
        this.ClinicaRepository = ClinicaRepository;
        this.PlanoRepository = PlanoRepository;
        this.rootDir = Paths.get("src/main/resources/static/upload");
    }

    @GetMapping
    public String list(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("procedimentos", ProcedimentoRepository.findAll(pageable));
        return "procedimento/listar";
    }

    @GetMapping("/editar")
    public String edit(Model model, @RequestParam Integer id) {
        model.addAttribute("procedimento", ProcedimentoRepository.findOne(id));
        model.addAttribute("clinicas", ClinicaRepository.findAll());
        model.addAttribute("planos", PlanoRepository.findAll());
        model.addAttribute("files", ProcedimentoRepository.findAll());
        return "procedimento/formulario";
    }
    
    @GetMapping("/excluir")
    public String excluir(Model model, @RequestParam Integer id) {
    	ProcedimentoRepository.delete(id);
        return "redirect:/procedimento";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("procedimento", new ProcedimentoDTO());
        model.addAttribute("clinicas", ClinicaRepository.findAll());
        model.addAttribute("planos", PlanoRepository.findAll());
        model.addAttribute("files", ProcedimentoRepository.findAll());
        return "procedimento/formulario";
    }
    
    @PostMapping("/salvar")
    public String salvar(@Valid ProcedimentoDTO procedimentoDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "procedimento/formulario";
        }
        Procedimento procedimento = new Procedimento();
        procedimento.setId(procedimentoDto.getId());
        procedimento.setNome(procedimentoDto.getNome());
        procedimento.setTipo(procedimentoDto.getTipo());
        procedimento.setCodproc(procedimentoDto.getCodproc());
        procedimento.setDescproc(procedimentoDto.getDescproc());
        procedimento.setPath(procedimentoDto.getFile().getOriginalFilename());
        handleFileUpload(procedimentoDto.getFile());
        ProcedimentoRepository.save(procedimento);
        return "redirect:/procedimento";
    }
    
	public void handleFileUpload(MultipartFile file)
			 {

		Path filePath = rootDir.resolve(file.getOriginalFilename());
		try {
			Files.copy(file.getInputStream(), filePath);
			ProcedimentoRepository.save(new Procedimento(file.getOriginalFilename(), filePath.toString()));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

    @GetMapping("/imagens")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@RequestParam("path") String filename) throws MalformedURLException {
		UrlResource file = new UrlResource(rootDir.resolve(filename).toUri());
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

    @RequestMapping(value = "/relatorio", method = RequestMethod.GET)
    public String relatorio(Model model,
           @RequestParam(defaultValue = "pdf") String format,
           HttpServletResponse response) {
        model.addAttribute("datasource", ProcedimentoRepository.findAll());
        model.addAttribute("format", format);
        return "reports/procedimentos";
    }

}
