package com.biblioteca.biblioteca.repository;

import com.biblioteca.biblioteca.model.Imprumut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ImprumutRepository extends JpaRepository<Imprumut, Integer> {
    List<Imprumut> findByIdUtilizator(Long idUtilizator);
}