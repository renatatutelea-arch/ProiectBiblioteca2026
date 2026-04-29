package com.biblioteca.biblioteca.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "imprumuturi")
public class Imprumut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "isbn_carte")
    private String isbnCarte;

    @Column(name = "id_utilizator")
    private Long idUtilizator;

    @Column(name = "data_imprumut")
    private LocalDate dataImprumut;

    @Column(name = "data_returnare_estimata")
    private LocalDate dataReturnareEstimata;

    @Column(name = "data_returnare_efectiva")
    private LocalDate dataReturnareEfectiva;

    @Column(name = "status")
    private String status;

    // Getteri si Setteri
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getIsbnCarte() { return isbnCarte; }
    public void setIsbnCarte(String isbnCarte) { this.isbnCarte = isbnCarte; }

    public Long getIdUtilizator() { return idUtilizator; }
    public void setIdUtilizator(Long idUtilizator) { this.idUtilizator = idUtilizator; }

    public LocalDate getDataImprumut() { return dataImprumut; }
    public void setDataImprumut(LocalDate dataImprumut) { this.dataImprumut = dataImprumut; }

    public LocalDate getDataReturnareEstimata() { return dataReturnareEstimata; }
    public void setDataReturnareEstimata(LocalDate dataReturnareEstimata) { this.dataReturnareEstimata = dataReturnareEstimata; }

    public LocalDate getDataReturnareEfectiva() { return dataReturnareEfectiva; }
    public void setDataReturnareEfectiva(LocalDate dataReturnareEfectiva) { this.dataReturnareEfectiva = dataReturnareEfectiva; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}