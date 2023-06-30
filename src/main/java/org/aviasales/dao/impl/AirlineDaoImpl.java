package org.aviasales.dao.impl;

import org.aviasales.dao.AirlineDao;
import org.aviasales.entity.Airline;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@Repository
public class AirlineDaoImpl extends AbstractDao<Airline> implements AirlineDao {
    protected AirlineDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Airline> getAll(int size, int offset) {
        return null;
    }

    @Override
    public Airline create(Airline airline) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO airline (name, code, description) VALUES(?,?,?);";

        getJdbcTemplate().update(con -> {
            PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, airline.getName_company());
            stmt.setString(2, airline.getCode_company());
            stmt.setString(3, airline.getDescription());
            return stmt;
        }, keyHolder);
        return findById(Objects.requireNonNull(keyHolder.getKey()).longValue());
    }

    @Override
    public Airline update(Airline airline, Long id) {
        return null;
    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public Airline findById(Long id) {
        try {
            return getJdbcTemplate().queryForObject("SELECT * FROM airline WHERE airline_id=?",
                    BeanPropertyRowMapper.newInstance(Airline.class), id);
        } catch (
                IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }
}
