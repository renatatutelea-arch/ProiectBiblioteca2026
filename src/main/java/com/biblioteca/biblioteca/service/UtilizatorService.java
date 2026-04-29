package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.Utilizator;
import com.biblioteca.biblioteca.repository.UtilizatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UtilizatorService {

    @Autowired
    private UtilizatorRepository utilizatorRepository;

    // Inregistreaza un utilizator nou, neaprobat
    public Utilizator register(Utilizator u) {
        u.setAprobat(false);
        return utilizatorRepository.save(u);
    }

    // Verifica email, parola si daca contul e aprobat
    public Optional<Utilizator> login(String email, String parola) {
        Optional<Utilizator> u = utilizatorRepository.findByEmail(email);
        if (u.isPresent() && u.get().getParola().equals(parola)) {
            if (u.get().getAprobat()) {
                return u;
            }
        }
        return Optional.empty();
    }

    // Returneaza toti utilizatorii
    public List<Utilizator> getAllUtilizatori() {
        return utilizatorRepository.findAll();
    }

    // Aproba un cont dupa ID
    public void aprobaUtilizator(Long id) {
        Optional<Utilizator> u = utilizatorRepository.findById(id);
        if (u.isPresent()) {
            u.get().setAprobat(true);
            utilizatorRepository.save(u.get());
        }
    }
}