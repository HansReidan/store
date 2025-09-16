package com.hansreidan.store.dao.impl;

import com.hansreidan.store.dao.LibroDAO;
import org.springframework.jdbc.core.JdbcTemplate;

public class LibroDaoImpl implements LibroDAO {

    private final JdbcTemplate jdbcTemplate;

    public LibroDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
