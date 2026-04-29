package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.Imprumut;
import com.biblioteca.biblioteca.repository.ImprumutRepository;
import com.biblioteca.biblioteca.repository.CarteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class ImprumutService {

    @Autowired
    private ImprumutRepository imprumutRepository;

    @Autowired
    private CarteRepository carteRepository;

    public List<Imprumut> getAll() {
        return imprumutRepository.findAll();
    }

    public List<Imprumut> getByUtilizator(Long idUtilizator) {
        return imprumutRepository.findByIdUtilizator(idUtilizator);
    }

    public Imprumut cereImprumut(String isbnCarte, Long idUtilizator) {
        Imprumut imprumut = new Imprumut();
        imprumut.setIsbnCarte(isbnCarte);
        imprumut.setIdUtilizator(idUtilizator);
        imprumut.setDataImprumut(LocalDate.now());
        imprumut.setDataReturnareEstimata(LocalDate.now().plusDays(14));
        imprumut.setStatus("pending");
        return imprumutRepository.save(imprumut);
    }

    public Imprumut aprobaImprumut(int id) {
        Imprumut imprumut = imprumutRepository.findById(id).orElseThrow();
        imprumut.setStatus("aprobat");
        carteRepository.findById(imprumut.getIsbnCarte()).ifPresent(carte -> {
            carte.setStatus("imprumutat");
            carteRepository.save(carte);
        });
        return imprumutRepository.save(imprumut);
    }

    public Imprumut respingeImprumut(int id) {
        Imprumut imprumut = imprumutRepository.findById(id).orElseThrow();
        imprumut.setStatus("respins");
        return imprumutRepository.save(imprumut);
    }

    public Imprumut returneazaCarte(int id) {
        Imprumut imprumut = imprumutRepository.findById(id).orElseThrow();
        imprumut.setStatus("returnat");
        imprumut.setDataReturnareEfectiva(LocalDate.now());
        carteRepository.findById(imprumut.getIsbnCarte()).ifPresent(carte -> {
            carte.setStatus("disponibil");
            carteRepository.save(carte);
        });
        return imprumutRepository.save(imprumut);
    }
}