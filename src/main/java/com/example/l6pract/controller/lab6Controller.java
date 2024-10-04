package com.example.l6pract.controller;

import com.example.l6pract.entity.Evento;
import com.example.l6pract.repository.EventoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class lab6Controller {

    private final EventoRepository eventoRepository;

    public lab6Controller(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    @GetMapping("")
    public String mpage(){

            return "index";

    }
    @GetMapping("/eventos")
    public String eventos(Model model){

        model.addAttribute("listaEventos", eventoRepository.findAll());
        return "eventos";

    }

    @GetMapping("/eventos/modificar")
    public String eventosMod(@ModelAttribute("evento") Evento evento,
                             Model model,
                             @RequestParam("id") int id){

        Optional<Evento> optionalEvento = eventoRepository.findById(id);
        optionalEvento.ifPresent(value -> model.addAttribute("evento", value));
        return "eventoForm";

    }
}
