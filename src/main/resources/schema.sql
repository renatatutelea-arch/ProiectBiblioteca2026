-- Creaza baza de date
CREATE DATABASE IF NOT EXISTS biblioteca;
USE biblioteca;

-- Tabelul carti
CREATE TABLE carti (
    isbn VARCHAR(20) PRIMARY KEY,
    titlu VARCHAR(200) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    editie VARCHAR(50),
    status ENUM('disponibil', 'imprumutat') DEFAULT 'disponibil'
);

-- Tabelul utilizatori
CREATE TABLE utilizatori (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    nume VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    parola VARCHAR(255) NOT NULL,
    rol ENUM('student', 'bibliotecar', 'admin') NOT NULL,
    aprobat BOOLEAN DEFAULT FALSE
);

-- Tabelul imprumuturi
CREATE TABLE imprumuturi (
    id INT AUTO_INCREMENT PRIMARY KEY,
    isbn_carte VARCHAR(20) NOT NULL,
    id_utilizator INT NOT NULL,
    data_imprumut DATE DEFAULT (CURRENT_DATE),
    data_returnare_estimata DATE,
    data_returnare_efectiva DATE,
    status ENUM('pending', 'aprobat', 'returnat', 'respins') DEFAULT 'pending',
    FOREIGN KEY (isbn_carte) REFERENCES carti(isbn),
    FOREIGN KEY (id_utilizator) REFERENCES utilizatori(ID)
);

-- Cont bibliotecar implicit (parola: admin123)
INSERT INTO utilizatori (nume, email, parola, rol, aprobat)
VALUES ('Bibliotecar', 'bibliotecar@biblioteca.ro', 'admin123', 'bibliotecar', TRUE);
