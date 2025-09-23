package com.hansreidan.store.devtiroTutorial.dao;

import com.hansreidan.store.devtiroTutorial.domain.Autore;
import com.hansreidan.store.devtiroTutorial.domain.Libro;

import java.util.Optional;

public interface LibroDAO {
    void create(Libro libro);

    Optional<Libro> findOne(String isbn);

    Optional<Libro> findAll(String isbn);

}
