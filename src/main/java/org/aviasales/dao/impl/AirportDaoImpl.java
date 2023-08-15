package org.aviasales.dao.impl;

import org.aviasales.dao.AirportDao;
import org.aviasales.entity.Airport;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class AirportDaoImpl extends AbstractDao<Airport> implements AirportDao {
    protected AirportDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Airport> getAll(int size, int offset) {
        return null;
    }

    @Override
    public Airport create(Airport airport) throws Exception {
        return null;
    }

    @Override
    public Airport update(Airport airport, Long id) {
        return null;
    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public Airport findById(Long id) {
        return null;
    }

    @Override
    public List<Airport> getFilterListAirport(String airportName, int page, int size) {
        return getJdbcTemplate().query("SELECT * FROM airport WHERE airport_name like '"+ airportName +"%' limit "+ size +" offset "+ page +";",
                BeanPropertyRowMapper.newInstance(Airport.class));
    }
}
