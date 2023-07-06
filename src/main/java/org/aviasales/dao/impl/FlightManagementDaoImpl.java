package org.aviasales.dao.impl;

import org.aviasales.dao.FlightManagementDao;
import org.aviasales.entity.FlightManagement;
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
public class FlightManagementDaoImpl extends AbstractDao<FlightManagement> implements FlightManagementDao {
    protected FlightManagementDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<FlightManagement> getAll(int size, int offset) {
        return getJdbcTemplate().query("SELECT * FROM flight_management limit ? offset ?;", BeanPropertyRowMapper.newInstance(FlightManagement.class), size, offset);
    }

    @Override
    public FlightManagement create(FlightManagement flightManagement) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO flight_management (flight_from_id, flight_to_id) VALUES(?,?);";

        getJdbcTemplate().update(con -> {
            PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, flightManagement.getFlightFrom().getFlightId());
            stmt.setLong(2, flightManagement.getFlightTo().getFlightId());
            return stmt;
        }, keyHolder);
        return findById(Objects.requireNonNull(keyHolder.getKey()).longValue());
    }

    @Override
    public FlightManagement update(FlightManagement flightManagement, Long id) {
        return null;
    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public FlightManagement findById(Long id) {
        try {
            return getJdbcTemplate().queryForObject("SELECT * FROM flight_management WHERE flight_management_id=?",
                    BeanPropertyRowMapper.newInstance(FlightManagement.class), id);
        } catch (
                IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<FlightManagement> getFlightManagementList(int size, int offset) {
        return null;
    }

    @Override
    public Integer countFlightManagement() {
        return getJdbcTemplate().queryForObject("select count(*) from flight_management", Integer.class);
    }
}
