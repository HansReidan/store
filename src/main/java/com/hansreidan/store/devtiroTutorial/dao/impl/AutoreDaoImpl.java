package com.hansreidan.store.devtiroTutorial.dao.impl;

import com.hansreidan.store.devtiroTutorial.dao.AutoreDAO;
import com.hansreidan.store.devtiroTutorial.domain.Autore;
import com.hansreidan.store.devtiroTutorial.domain.Libro;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AutoreDaoImpl implements AutoreDAO {

    private final JdbcTemplate jdbcTemplate;

    public AutoreDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Autore autore) {
        jdbcTemplate.update("INSERT INTO autore (id, autore, eta) VALUES (?, ?, ?)",
                autore.getId(), autore.getAutore(), autore.getEta()

        );
    }

    @Override
    public Optional<Autore> findOne(long id) {
        List<Autore> results = jdbcTemplate.query(
                "SELECT id, autore.autore, eta FROM autore WHERE id = ? LIMIT 1",
                new AutoreRowMapper(), id);
        return results.stream().findFirst();
    }

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
