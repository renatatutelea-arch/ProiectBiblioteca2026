package com.biblioteca.biblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name = "utilizatori")
public class Utilizator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Nume")
    private String nume;

    @Column(name = "Email")
    private String email;

    @Column(name = "Parola")
    private String parola;

    @Column(name = "Rol")
    private String rol;

    @Column(name = "Aprobat")
    private Boolean aprobat = false;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getParola() { return parola; }
    public void setParola(String parola) { this.parola = parola; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public Boolean getAprobat() { return aprobat; }
    public void setAprobat(Boolean aprobat) { this.aprobat = aprobat; }
}