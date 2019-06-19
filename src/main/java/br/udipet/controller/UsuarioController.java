package br.udipet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.udipet.entity.Usuario;
import br.udipet.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	    private UsuarioRepository usuarioRepository;
	    
	    @Autowired
		private BCryptPasswordEncoder passwordEncoder;

	    public UsuarioController(UsuarioRepository usuarioRepository) {
	        this.usuarioRepository = usuarioRepository;
	    }

	    @GetMapping
	    public String list(Model model) {
	        model.addAttribute("usuarios", usuarioRepository.findAll());
	        return "usuario/listar";
	    }

	    @GetMapping("/editar")
	    public String edit(Model model, @RequestParam Integer id) {
	        model.addAttribute("usuario", usuarioRepository.findOne(id));
	        model.addAttribute("files", usuarioRepository.findAll());
	        return "usuario/formulario";
	    }

	    @GetMapping("/novo")
	    public String novo(Model model) {
	        model.addAttribute("usuario", new Usuario());
	        model.addAttribute("files", usuarioRepository.findAll());
	        return "usuario/formulario";
	    }

	    @GetMapping("/excluir")
	    public String excluir(Model model, @RequestParam Integer id) {
	    	usuarioRepository.delete(id);
	        return "redirect:/usuario";
	    }
	    
	    @PostMapping("/salvar")
	    public String salvar(@Valid Usuario usuario, BindingResult bindingResult) {
	        if (bindingResult.hasErrors()) {
	            return "usuario/formulario";
	        }
	        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
	        usuarioRepository.save(usuario);
	        return "redirect:/usuario";
	    }
}
