package com.biblioteca.biblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name = "carti")
public class carte {

    @Id
    @Column(name = "ISBN")
    private String ISBN;

    @Column(name = "Titlu")
    private String Titlu;

    @Column(name = "Autor")
    private String Autor;

    @Column(name = "Editie")
    private String Editie;

    @Column(name = "Status")
    private String Status;

    public String getIsbn() { return ISBN; }
    public void setIsbn(String ISBN) { this.ISBN = ISBN; }

    public String getTitlu() { return Titlu; }
    public void setTitlu(String Titlu) { this.Titlu = Titlu; }

    public String getAutor() { return Autor; }
    public void setAutor(String Autor) { this.Autor = Autor; }

    public String getEditie() { return Editie; }
    public void setEditie(String Editie) { this.Editie = Editie; }

    public String getStatus() { return Status; }
    public void setStatus(String Status) { this.Status = Status; }
}
