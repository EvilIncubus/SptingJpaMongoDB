package org.aviasales.dao.impl;

import org.aviasales.dao.FlightDao;
import org.aviasales.entity.Flight;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Repository
public class FlightDaoImpl extends AbstractDao<Flight> implements FlightDao {
    protected FlightDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Flight> getAll(int size, int offset) {
        return getJdbcTemplate().query("SELECT * FROM flight limit ? offset ?;", BeanPropertyRowMapper.newInstance(Flight.class), size, offset);
    }

    @Override
    public Flight create(Flight flight) throws Exception {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO flight (airplane_id, departure_location, destination, departure_date_time, arrival_date_time, duration_id) VALUES(?,?,?,?,?,?);";

        getJdbcTemplate().update(con -> {
            PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, flight.getAirplane().getAirplaneId());
            stmt.setString(2, flight.getDepartureLocation());
            stmt.setString(3, flight.getDestination());
            stmt.setTimestamp(4, Timestamp.valueOf(flight.getDepartureDateTime()));
            stmt.setTimestamp(5, Timestamp.valueOf(flight.getArrivalDateTime()));
            stmt.setString(6, flight.getFlightDuration().toString());
            return stmt;
        }, keyHolder);
        if(null != findById(Objects.requireNonNull(keyHolder.getKey()).longValue())){
            flight.setFlightId(keyHolder.getKey().longValue());
        }
        else {
            throw new Exception("Could not save flight on database");
            // exception read
        }
        return flight;
    }

    @Override
    public Flight update(Flight flight, Long id) {
        return null;
    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public Flight findById(Long id) {
        try {
            return getJdbcTemplate().queryForObject("SELECT * FROM flight WHERE flight_id=?",
                    BeanPropertyRowMapper.newInstance(Flight.class), id);
        } catch (
                IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Flight> getFlightList(int size, int offset) {
        return null;
    }

    @Override
    public Integer countFlight() {
        return getJdbcTemplate().queryForObject("select count(*) from flight", Integer.class);
    }
}
