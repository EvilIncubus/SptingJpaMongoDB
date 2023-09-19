package org.aviasales.dao.impl;

import org.aviasales.dao.FlightManagementDao;
import org.aviasales.dao.rowmapper.FlightManagementRowMapper;
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
        return getJdbcTemplate().query("SELECT fm.flight_management_id as flight_management_id, \n" +
                        "\t\tf.flight_id as origin_flight_flight_id,\n" +
                        "\t\tf.flight_number as origin_flight_flight_number,\n" +
                        "\t\tf.departure_location as origin_flight_departure_destination,\n" +
                        "\t\tf.destination  as origin_flight_destination,\n" +
                        "\t\tf.departure_date_time as origin_flight_departure_date_time,\n" +
                        "\t\tf.arrival_date_time as origin_flight_arrival_date_time,\n" +
                        "\t\tf2.flight_id as destination_flight_flight_id,\n" +
                        "\t\tf2.flight_number as destination_flight_flight_number,\n" +
                        "\t\tf2.departure_location as destination_flight_departure_destination,\n" +
                        "\t\tf2.destination  as destination_flight_destination,\n" +
                        "\t\tf2.departure_date_time as destination_flight_departure_date_time,\n" +
                        "\t\tf2.arrival_date_time as destination_flight_arrival_date_time\n" +
                        "\t\tFROM flight_management fm \n" +
                        "inner join flight f on f.flight_id = fm.origin_flight_id\n" +
                        "inner join airplane a on a.airplane_id = f.airplane_id \n" +
                        "inner join airline a2 on a2.airline_id = a.airline_id \n" +
                        "inner join flight f2 on f2.flight_id = fm.destination_flight_id\n" +
                        "inner join airplane a3 on a3.airplane_id = f2.airplane_id \n" +
                        "INNER JOIN  airline a4 on a4.airline_id = a3.airline_id  limit ? offset ?;",
                new FlightManagementRowMapper(), size, offset);
    }

    @Override
    public FlightManagement create(FlightManagement flightManagement) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO flight_management (destination_flight_id, origin_flight_id) VALUES(?,?);";

        getJdbcTemplate().update(con -> {
            PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, flightManagement.getDestinationFlight().getFlightId());
            stmt.setLong(2, flightManagement.getOriginFlight().getFlightId());
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
