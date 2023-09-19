package org.aviasales.dao;

import org.aviasales.entity.User;

public interface UserDao extends Dao<User> {
    User findByEmail(String email);
}
