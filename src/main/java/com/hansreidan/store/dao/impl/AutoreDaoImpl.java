package com.hansreidan.store.dao.impl;

import com.hansreidan.store.dao.AutoreDAO;
import org.springframework.jdbc.core.JdbcTemplate;

public class AutoreDaoImpl implements AutoreDAO {

    private final JdbcTemplate jdbcTemplate;

    public AutoreDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
