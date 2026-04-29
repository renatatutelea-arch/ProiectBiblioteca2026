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
    @Autowired
    private com.biblioteca.biblioteca.service.IsbnLookupService isbnLookupService;

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
    @GetMapping("/api/carti/lookup/{isbn}")
@ResponseBody
public org.springframework.http.ResponseEntity<carte> cautaDupaIsbn(@PathVariable String isbn) {
    carte c = isbnLookupService.lookup(isbn);
    if (c == null) {
        return org.springframework.http.ResponseEntity.notFound().build();
    }
    return org.springframework.http.ResponseEntity.ok(c);
}
}