package br.udipet.controller;

import br.udipet.entity.Clinica;
import br.udipet.repository.ClinicaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/clinica")
public class ClinicaController {

    private ClinicaRepository clinicaRepository;

    public ClinicaController(ClinicaRepository clinicaRepository) {
        this.clinicaRepository = clinicaRepository;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("clinicas", clinicaRepository.findAll());
        return "clinica/listar";
    }

    @GetMapping("/editar")
    public String edit(Model model, @RequestParam Integer id) {
        model.addAttribute("clinica", clinicaRepository.findOne(id));
        return "clinica/formulario";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("clinica", new Clinica());
        return "clinica/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Clinica clinica, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "clinica/formulario";
        }
        clinicaRepository.save(clinica);
        return "redirect:/clinica";
    }

    @GetMapping("/excluir")
    public String excluir(Model model, @RequestParam Integer id) {
        clinicaRepository.delete(id);
        return "redirect:/clinica";
    }
}
