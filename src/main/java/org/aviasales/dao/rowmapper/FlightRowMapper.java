package org.aviasales.dao.rowmapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class FlightRowMapper implements RowMapper<LocalDateTime> {
    @Override
    public LocalDateTime mapRow(ResultSet rs, int rowNum) throws SQLException {
        return rs.getTimestamp("departure_date_time").toLocalDateTime();
    }
}
