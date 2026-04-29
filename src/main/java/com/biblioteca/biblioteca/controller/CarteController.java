package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.carte;
import com.biblioteca.biblioteca.service.CarteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class CarteController {

    @Autowired
    private CarteService carteService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/api/carti")
    @ResponseBody
    public List<carte> getAllCarti() {
        return carteService.getAllCarti();
    }

    @PostMapping("/api/carti")
    @ResponseBody
    public carte adaugaCarte(@RequestBody carte carte) {
        return carteService.saveCarte(carte);
    }

    @DeleteMapping("/api/carti/{isbn}")
    @ResponseBody
    public String stergeCarte(@PathVariable String isbn) {
        carteService.deleteCarte(isbn);
        return "Carte ștearsă!";
    }
}