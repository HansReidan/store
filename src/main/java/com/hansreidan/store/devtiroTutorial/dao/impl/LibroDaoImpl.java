package com.hansreidan.store.devtiroTutorial.dao.impl;

import com.hansreidan.store.devtiroTutorial.dao.LibroDAO;
import com.hansreidan.store.devtiroTutorial.domain.Autore;
import com.hansreidan.store.devtiroTutorial.domain.Libro;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Libro> findOne(String isbn) {
        return Optional.empty();
    }

    @Override
    public Optional<Libro> findAll(String ibsn) {
        List<Libro> results = jdbcTemplate.query(
                "SELECT id, libro.autore, eta FROM autore WHERE id = ? LIMIT 1",
                new LibroDaoImpl.LibroRowMapper(), ibsn);
        return results.stream().findFirst();
    }

    public static class LibroRowMapper implements RowMapper<Libro> {

        @Override
        public Libro mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Libro.builder()
                    .isbn(rs.getString("isbn"))
                    .titolo(rs.getString("titolo"))
                    .autoreId(rs.getLong("autoreid"))
                    .build();
        }
    }
}
