package com.biblioteca.biblioteca.repository;

import com.biblioteca.biblioteca.model.carte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteRepository extends JpaRepository<carte, String> {

}