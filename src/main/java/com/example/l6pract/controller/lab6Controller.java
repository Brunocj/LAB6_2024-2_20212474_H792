package com.example.l6pract.controller;

import com.example.l6pract.entity.Director;
import com.example.l6pract.entity.Pelicula;
import com.example.l6pract.repository.DirectorRepository;
import com.example.l6pract.repository.PeliculaRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class lab6Controller {

    private final DirectorRepository directorRepository;
    private final PeliculaRepository peliculaRepository;

    public lab6Controller(DirectorRepository directorRepository,
                          PeliculaRepository peliculaRepository) {
        this.directorRepository = directorRepository;
        this.peliculaRepository = peliculaRepository;
    }

    @GetMapping("")
    public String mpage(){

            return "index";

    }
    @GetMapping("/peliculas")
    public String peliculas(Model model){

        model.addAttribute("listaPelis", peliculaRepository.findAll());
        return "peliculas";

    }

    @GetMapping("/peliculas/modificar")
    public String peliculasMod(@ModelAttribute("pelicula") Pelicula pelicula,
                             Model model,
                             @RequestParam("id") int id){

        Optional<Pelicula> optPelicula = peliculaRepository.findById(id);
        optPelicula.ifPresent(value -> model.addAttribute("pelicula", value));
        Boolean flag = true;
        model.addAttribute("editar", flag);
        return "peliculaForm";

    }

    @GetMapping("/pelicula/crear")
    public String peliculasMod(@ModelAttribute("pelicula") Pelicula pelicula,
                               Model model){
        Pelicula peliculaCrear = new Pelicula();

        model.addAttribute("pelicula", peliculaCrear);
        return "peliculaForm";

    }

    @PostMapping("/pelicula/save")
    public String peliculasModSave(@ModelAttribute("pelicula") @Valid Pelicula pelicula, BindingResult bindingResult,
                                   RedirectAttributes attr){

        peliculaRepository.save(pelicula);
        return "redirect:/peliculas";

    }

    @GetMapping("/director")
    public String directores(Model model){

        model.addAttribute("listaDirectores", directorRepository.findAll());
        return "directores";

    }



    @GetMapping("/director/crear")
    public String directoresCrear(@ModelAttribute("director") Director director,
                                Model model){

        model.addAttribute("director", director);
        return "directorForm";

    }

    @PostMapping("/director/save")
    public String directorSave(@ModelAttribute("director") @Valid Director director, BindingResult bindingResult,
                               RedirectAttributes attr){

        directorRepository.save(director);
        return "redirect:/director";

    }
}
