package org.aviasales.dao.impl;

import org.aviasales.dao.SeatDao;
import org.aviasales.entity.Flight;
import org.aviasales.entity.Seat;
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
public class SeatDaoImpl extends AbstractDao<Seat> implements SeatDao {
    protected SeatDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Seat> getAll(int size, int offset) {
        return null;
    }

    @Override
    public Seat create(Seat seat) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO seat (seatType, place_number, available_place, price_seat, flight_id) VALUES(?,?,?,?,?);";

        getJdbcTemplate().update(con -> {
            PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, seat.getSeatType().ordinal());
            stmt.setInt(2, seat.getPlaceNumber());
            stmt.setBoolean(3, seat.isAvailablePlace());
            stmt.setDouble(4, seat.getPriceSeat());
            stmt.setLong(5, seat.getFlightId());
            return stmt;
        }, keyHolder);
        return findById(Objects.requireNonNull(keyHolder.getKey()).longValue());
    }

    @Override
    public Seat update(Seat seat, Long id) {
        return null;
    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public Seat findById(Long id) {
        try {
            return getJdbcTemplate().queryForObject("SELECT * FROM seat WHERE seat_id=?",
                    BeanPropertyRowMapper.newInstance(Seat.class), id);
        } catch (
                IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }
}
