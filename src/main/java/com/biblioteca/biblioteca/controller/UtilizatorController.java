package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Utilizator;
import com.biblioteca.biblioteca.service.UtilizatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class UtilizatorController {

    @Autowired
    private UtilizatorService utilizatorService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/dashboard-bibliotecar")
    public String dashboardBibliotecar() {
        return "dashboard-bibliotecar";
    }

    @GetMapping("/dashboard-student")
    public String dashboardStudent() {
        return "dashboard-student";
    }

    @PostMapping("/api/register")
    @ResponseBody
    public String register(@RequestBody Utilizator u) {
        utilizatorService.register(u);
        return "Cont creat! Asteapta aprobarea bibliotecarului.";
    }

    @PostMapping("/api/login")
    @ResponseBody
    public Map<String, Object> login(@RequestBody Utilizator u) {
        Map<String, Object> raspuns = new HashMap<>();
        Optional<Utilizator> rezultat = utilizatorService.login(u.getEmail(), u.getParola());
        if (rezultat.isPresent()) {
            Utilizator utilizator = rezultat.get();
            raspuns.put("id", utilizator.getId());
            raspuns.put("rol", utilizator.getRol());
            raspuns.put("nume", utilizator.getNume());
        } else {
            raspuns.put("eroare", "Email sau parola gresita, sau cont neaprobat.");
        }
        return raspuns;
    }

    @GetMapping("/api/utilizatori")
    @ResponseBody
    public List<Utilizator> getAllUtilizatori() {
        return utilizatorService.getAllUtilizatori();
    }

    @PostMapping("/api/aproba/{ID}")
    @ResponseBody
    public String aprobaUtilizator(@PathVariable Long ID) {
        utilizatorService.aprobaUtilizator(ID);
        return "Cont aprobat!";
    }
}