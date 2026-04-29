package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Imprumut;
import com.biblioteca.biblioteca.service.ImprumutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/imprumuturi")
public class ImprumutController {

    @Autowired
    private ImprumutService imprumutService;

    // GET - toate imprumuturile (pentru bibliotecar)
    @GetMapping
    public List<Imprumut> getAll() {
        return imprumutService.getAll();
    }

    // POST - cerere imprumut de la student
    @PostMapping("/cere")
    public Imprumut cereImprumut(@RequestBody Map<String, String> body) {
        String isbn = body.get("isbnCarte");
        Long idUtilizator = Long.parseLong(body.get("idUtilizator"));
        return imprumutService.cereImprumut(isbn, idUtilizator);
    }

    // POST - bibliotecar aproba
    @PostMapping("/aproba/{id}")
    public Imprumut aprobaImprumut(@PathVariable int id) {
        return imprumutService.aprobaImprumut(id);
    }

    // POST - bibliotecar respinge
    @PostMapping("/respinge/{id}")
    public Imprumut respingeImprumut(@PathVariable int id) {
        return imprumutService.respingeImprumut(id);
    }

    // POST - returneaza carte
    @PostMapping("/returneaza/{id}")
    public Imprumut returneazaCarte(@PathVariable int id) {
        return imprumutService.returneazaCarte(id);
    }
}