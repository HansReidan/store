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
    public Optional<Libro> find(String isbn) {
        return Optional.empty();
    }

//    @Override
//    public Optional<Autore> find(long id) {
//        List<Autore> results = jdbcTemplate.query(
//                "SELECT id, autore.autore, eta FROM autore WHERE id = ? LIMIT 1",
//                new AutoreDaoImpl.AutoreRowMapper(), id);
//        return results.stream().findFirst();
//    }

    public static class AutoreRowMapper implements RowMapper<Autore> {

        @Override
        public Autore mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Autore.builder()
                    .id(rs.getLong("id"))
                    .autore(rs.getString("autore"))
                    .eta(rs.getInt("eta"))
                    .build();
        }
    }
}
