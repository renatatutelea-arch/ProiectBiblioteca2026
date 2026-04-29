package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.carte;
import com.biblioteca.biblioteca.repository.CarteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarteService {

    @Autowired
    private CarteRepository carteRepository;

    public List<carte> getAllCarti() {
        return carteRepository.findAll();
    }

    public carte saveCarte(carte c) {
        return carteRepository.save(c);
    }

    public void deleteCarte(String ISBN) {
        carteRepository.deleteById(ISBN);
    }
    public carte save(carte carte) {
    return carteRepository.save(carte);
}
public void delete(String isbn) {
    carteRepository.deleteById(isbn);
}
}