package org.aviasales.dao.impl;

import org.aviasales.dao.AirplaneDao;
import org.aviasales.dao.rowmapper.FlightManagementRowMapper;
import org.aviasales.entity.Airline;
import org.aviasales.entity.Airplane;
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
public class AirplaneDaoImpl extends AbstractDao<Airplane> implements AirplaneDao {
    protected AirplaneDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Airplane> getAll(int size, int offset) {
        return getJdbcTemplate().query("SELECT * From aviasales_db.airplane limit ? offset ?;",
                BeanPropertyRowMapper.newInstance(Airplane.class), size, offset);
    }

    @Override
    public Airplane create(Airplane airplane) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO aviasales_db.airplane (plane_number, airline_id, number_of_seats) VALUES(?,?,?);";

        getJdbcTemplate().update(con -> {
            PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, airplane.getPlaneNumber());
            stmt.setLong(2, airplane.getAirline().getAirlineId());
            stmt.setInt(3, airplane.getNumberOfSeats());
            return stmt;
        }, keyHolder);
        return findById(Objects.requireNonNull(keyHolder.getKey()).longValue());
    }

    @Override
    public Airplane update(Airplane airplane, Long id) {
        return null;
    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public Airplane findById(Long id) {
        try {
            return getJdbcTemplate().queryForObject("SELECT * FROM aviasales_db.airplane WHERE airplane_id=?",
                    BeanPropertyRowMapper.newInstance(Airplane.class), id);
        } catch (
                IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public Integer countFlightManagement() {
        return getJdbcTemplate().queryForObject("select count(*) from aviasales_db.airplane", Integer.class);
    }
}
