package org.aviasales.dao.impl;

import org.aviasales.dao.ProfileDao;
import org.aviasales.dao.UserDao;
import org.aviasales.entity.Profile;
import org.aviasales.entity.User;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ProfileDaoImpl extends AbstractDao<Profile> implements ProfileDao {
    protected ProfileDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Profile> getAll(int size, int offset) {
        return null;
    }

    @Override
    public Profile create(Profile profile) throws Exception {
        return null;
    }

    @Override
    public Profile update(Profile profile, Long id) {
        return null;
    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public Profile findById(Long id) {
        return null;
    }

    @Override
    public Profile getProfileByUserId(int userId) {
        try {
            return getJdbcTemplate().queryForObject("SELECT * FROM profile WHERE user_id=?",
                    BeanPropertyRowMapper.newInstance(Profile.class), userId);
        } catch (
                IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }
}
