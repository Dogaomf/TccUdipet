package br.udipet.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.udipet.entity.Fornecedor;
import br.udipet.repository.FornecedorRepository;

@Controller
@RequestMapping("/fornecedor")
public class FornecedorController {

	    private FornecedorRepository fornecedorRepository;

	    public FornecedorController(FornecedorRepository fornecedorRepository) {
	        this.fornecedorRepository = fornecedorRepository;
	    }

	    @GetMapping
	    public String list(Model model) {
	        model.addAttribute("fornecedores", fornecedorRepository.findAll());
	        return "fornecedor/listar";
	    }

	    @GetMapping("/editar")
	    public String edit(Model model, @RequestParam Integer id) {
	        model.addAttribute("fornecedor", fornecedorRepository.findOne(id));
	        return "fornecedor/formulario";
	    }

	    @GetMapping("/novo")
	    public String novo(Model model) {
	        model.addAttribute("fornecedor", new Fornecedor());
	        return "fornecedor/formulario";
	    }

	    @PostMapping("/salvar")
	    public String salvar(@Valid Fornecedor fornecedor, BindingResult bindingResult) {
	        if (bindingResult.hasErrors()) {
	            return "fornecedor/formulario";
	        }
	        fornecedorRepository.save(fornecedor);
	        return "redirect:/fornecedor";
	    }

	    @GetMapping("/excluir")
	    public String excluir(Model model, @RequestParam Integer id) {
	    	fornecedorRepository.delete(id);
	        return "redirect:/fornecedor";
	    }
}
