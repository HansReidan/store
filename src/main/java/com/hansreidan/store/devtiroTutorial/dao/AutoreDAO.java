package com.hansreidan.store.devtiroTutorial.dao;

import com.hansreidan.store.devtiroTutorial.domain.Autore;
import com.hansreidan.store.devtiroTutorial.domain.Libro;

import java.util.Optional;

public interface AutoreDAO {

    void create(Autore autore);

    Optional<Autore> findOne(long id);
}
