package org.aviasales.dao.impl;

import org.aviasales.dao.UserDao;
import org.aviasales.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    protected UserDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<User> getAll(int size, int offset) {
        return null;
    }

    @Override
    public User create(User user) throws Exception {
        return null;
    }

    @Override
    public User update(User user, Long id) {
        return null;
    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return getJdbcTemplate().queryForObject("SELECT * FROM user WHERE email=?",
                BeanPropertyRowMapper.newInstance(User.class), email);
    }
}
