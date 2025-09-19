package com.hansreidan.store.devtiroTutorial.dao;

import com.hansreidan.store.devtiroTutorial.domain.Libro;

import java.util.Optional;

public interface LibroDAO {
    void create(Libro libro);

    Optional<Libro> find(String isbn);
}
