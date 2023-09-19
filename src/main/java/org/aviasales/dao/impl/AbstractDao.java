package org.aviasales.dao.impl;

import org.aviasales.dao.Dao;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public abstract class AbstractDao<T> implements Dao<T> {

    private final JdbcTemplate jdbcTemplate;

    protected AbstractDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }


}