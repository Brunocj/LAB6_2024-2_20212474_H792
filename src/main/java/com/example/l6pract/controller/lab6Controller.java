package com.example.l6pract.controller;

import com.example.l6pract.entity.Pelicula;
import com.example.l6pract.repository.DirectorRepository;
import com.example.l6pract.repository.PeliculaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/director")
    public String directores(Model model){

        model.addAttribute("listaPelis", directorRepository.findAll());
        return "directores";

    }

    @GetMapping("/director/modificar")
    public String directoresMod(@ModelAttribute("pelicula") Pelicula pelicula,
                               Model model,
                               @RequestParam("id") int id){

        Optional<Pelicula> optPelicula = peliculaRepository.findById(id);
        optPelicula.ifPresent(value -> model.addAttribute("evento", value));
        return "directorForm";

    }
}
