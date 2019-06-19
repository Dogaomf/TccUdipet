package br.udipet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.udipet.entity.Marcacao;
import br.udipet.repository.ClinicaRepository;
import br.udipet.repository.MarcacaoRepository;
import br.udipet.repository.PlanoRepository;
import br.udipet.repository.ProcedimentoRepository;
import br.udipet.repository.UsuarioRepository;

@Controller
@RequestMapping("/marcacao")
public class MarcacaoController {
		
	    private MarcacaoRepository marcacaoRepository;
	    private UsuarioRepository usuarioRepository;
	    private PlanoRepository planoRepository;
	    private ProcedimentoRepository procedimentoRepository;
	    private ClinicaRepository clinicaRepository;
	    
	    public MarcacaoController(MarcacaoRepository marcacaoRepository, UsuarioRepository
	    		usuarioRepository, PlanoRepository planoRepository, ProcedimentoRepository procedimentoRepository,
	    		ClinicaRepository clinicaRepository) {
	        this.marcacaoRepository = marcacaoRepository;
	        this.usuarioRepository = usuarioRepository;
	        this.planoRepository = planoRepository;
	        this.procedimentoRepository = procedimentoRepository;
	        this.clinicaRepository = clinicaRepository;
	    }

	    @GetMapping
	    public String list(Model model) {
	        model.addAttribute("marcacoes", marcacaoRepository.findAll());
	        model.addAttribute("usuarios", usuarioRepository.findAll());
	        model.addAttribute("planos", planoRepository.findAll());
	        model.addAttribute("procedimentos", procedimentoRepository.findAll());
	        model.addAttribute("clinicas", clinicaRepository.findAll());
	        return "marcacao/listar";
	    }

	    @GetMapping("/editar")
	    public String edit(Model model, @RequestParam Integer id) {
	        model.addAttribute("marcacao", marcacaoRepository.findOne(id));
	        model.addAttribute("usuarios", usuarioRepository.findAll());
	        model.addAttribute("planos", planoRepository.findAll());
	        model.addAttribute("procedimentos", procedimentoRepository.findAll());
	        model.addAttribute("clinicas", clinicaRepository.findAll());
	        return "marcacao/formulario";
	    }
	    
	    @GetMapping("/buscarStatus")
	public String buscarStatus(Model model, @RequestParam String tipoStatus) {
		if (tipoStatus != null && tipoStatus.equals("Todos")) {
			model.addAttribute("marcacoes", marcacaoRepository.findAll());
		} else {
			model.addAttribute("marcacoes", marcacaoRepository.findByStatusExec(tipoStatus));
		}

		// model.addAttribute("usuarios", usuarioRepository.findAll());
		// model.addAttribute("planos", planoRepository.findAll());
		// model.addAttribute("procedimentos", procedimentoRepository.findAll());
		// model.addAttribute("clinicas", clinicaRepository.findAll());
		return "marcacao/listar";
	}

	    @GetMapping("/novo")
	    public String novo(Model model) {
	        model.addAttribute("marcacao", new Marcacao());
	        model.addAttribute("usuarios", usuarioRepository.findAll());
	        model.addAttribute("planos", planoRepository.findAll());
	        model.addAttribute("procedimentos", procedimentoRepository.findAll());
	        model.addAttribute("clinicas", clinicaRepository.findAll());
	        return "marcacao/formulario";
	    }

	    @PostMapping("/salvar")
	    public String salvar(@Valid Marcacao marcacao, BindingResult bindingResult) {
	        if (bindingResult.hasErrors()) {
	            return "marcacao/formulario";
	        }
	        marcacaoRepository.save(marcacao);
	        return "redirect:/marcacao";
	    }

	    @GetMapping("/excluir")
	    public String excluir(Model model, @RequestParam Integer id) {
	    	marcacaoRepository.delete(id);
	        return "redirect:/marcacao";
	    }
}
