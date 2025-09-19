package com.hansreidan.store.devtiroTutorial.dao.impl;

import com.hansreidan.store.devtiroTutorial.dao.LibroDAO;
import com.hansreidan.store.devtiroTutorial.domain.Libro;
import org.springframework.jdbc.core.JdbcTemplate;

public class LibroDaoImpl implements LibroDAO {

    private final JdbcTemplate jdbcTemplate;

    public LibroDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Libro libro) {
        jdbcTemplate.update("INSERT INTO books (isbn, titolo, autoreId) VALUES (?, ?, ?)",
                libro.getIsbn(), libro.getTitolo(), libro.getAutoreId()

                );
    }
}
