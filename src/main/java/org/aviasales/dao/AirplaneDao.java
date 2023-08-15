package org.aviasales.dao;

import org.aviasales.entity.Airplane;

public interface AirplaneDao extends Dao<Airplane>{
    Integer countFlightManagement();
}
