package com.biblioteca.biblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name = "carti")
public class carte {

    @Id
    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "Titlu")
    private String titlu;

    @Column(name = "Autor")
    private String autor;

    @Column(name = "Editie")
    private String editie;

    @Column(name = "Status")
    private String status;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String ISBN) {
        this.isbn = ISBN;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String Titlu) {
        this.titlu = Titlu;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String Autor) {
        this.autor = Autor;
    }

    public String getEditie() {
        return editie;
    }

    public void setEditie(String Editie) {
        this.editie = Editie;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String Status) {
        this.status = Status;
    }
}
