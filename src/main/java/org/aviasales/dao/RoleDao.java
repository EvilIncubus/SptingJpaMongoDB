package org.aviasales.dao;

import org.aviasales.entity.Roles;

public interface RoleDao extends Dao<Roles>{
    String findByUserId(long userId);
}
