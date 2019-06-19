package br.udipet.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.Valid;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import br.udipet.dto.AnimalDTO;
import br.udipet.entity.Animal;
import br.udipet.repository.AnimalRepository;

@Controller
@RequestMapping("/animal")
public class AnimalController {

	    private AnimalRepository animalRepository;
	    final Path rootDir;

	    public AnimalController(AnimalRepository animalRepository) {
	        this.animalRepository = animalRepository;
	        this.rootDir = Paths.get("src/main/resources/static/upload");
	    }

	    @GetMapping
	    public String list(Model model) {
	        model.addAttribute("animais", animalRepository.findAll());
	        return "animal/listar";
	    }

	    @GetMapping("/editar")
	    public String edit(Model model, @RequestParam Integer id) {
	        model.addAttribute("animal", animalRepository.findOne(id));
	        model.addAttribute("files", animalRepository.findAll());
	        return "animal/formulario";
	    }

	    @GetMapping("/novo")
	    public String novo(Model model) {
	        model.addAttribute("animal", new Animal());
	        model.addAttribute("files", animalRepository.findAll());
	        return "animal/formulario";
	    }
	    
	    @GetMapping("/excluir")
	    public String excluir(Model model, @RequestParam Integer id) {
	    	animalRepository.delete(id);
	        return "redirect:/animal";
	    }
	    
	    @PostMapping("/salvar")
	    public String salvar(@Valid AnimalDTO animalDto, BindingResult bindingResult) {
	        if (bindingResult.hasErrors()) {
	            return "animal/formulario";
	        }
	        Animal animal = new Animal();
	        animal.setId(animalDto.getId());
	        animal.setNome(animalDto.getNome());
	        animal.setTipo(animalDto.getTipo());
	        animal.setPeso(animalDto.getPeso());
	        animal.setRaca(animalDto.getRaca());
	        animal.setCor(animalDto.getCor());
	        animal.setPelagem(animalDto.getPelagem());
	        
	        if(animalDto.getFile() != null) {
	        	animal.setPath(animalDto.getFile().getOriginalFilename());
	        	handleFileUpload(animalDto.getFile());
	        }
	        
	        animalRepository.save(animal);
	        return "redirect:/animal";
	    }
	    
	    public void handleFileUpload(MultipartFile file) {

			Path filePath = rootDir.resolve(file.getOriginalFilename());
			try {
				Files.copy(file.getInputStream(), filePath);
				animalRepository.save(new Animal(file.getOriginalFilename(), filePath.toString()));
				
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
}
