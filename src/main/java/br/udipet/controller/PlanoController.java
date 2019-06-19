package br.udipet.controller;

import br.udipet.entity.Plano;
import br.udipet.repository.PlanoRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/plano")
public class PlanoController {

    private PlanoRepository planoRepository;

    public PlanoController(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("planos", planoRepository.findAll());
        return "plano/listar";
    }

    @GetMapping("/editar")
    public String edit(Model model, @RequestParam Integer id) {
        model.addAttribute("plano", planoRepository.findOne(id));
        return "plano/formulario";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("plano", new Plano());
        return "plano/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Plano plano, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "plano/formulario";
        }
        planoRepository.save(plano);
        return "redirect:/plano";
    }

    @GetMapping("/excluir")
    public String excluir(Model model, @RequestParam Integer id) {
    	planoRepository.delete(id);
        return "redirect:/plano";
    }
}