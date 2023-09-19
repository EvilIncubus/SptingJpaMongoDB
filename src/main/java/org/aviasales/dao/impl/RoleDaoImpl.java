package org.aviasales.dao.impl;

import org.aviasales.dao.RoleDao;
import org.aviasales.entity.Roles;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class RoleDaoImpl extends AbstractDao<Roles> implements RoleDao {
    protected RoleDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Roles> getAll(int size, int offset) {
        return null;
    }

    @Override
    public Roles create(Roles roles) throws Exception {
        return null;
    }

    @Override
    public Roles update(Roles roles, Long id) {
        return null;
    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public Roles findById(Long id) {
        return null;
    }

    @Override
    public String findByUserId(long userId) {
        return getJdbcTemplate().queryForObject("SELECT role FROM user_role WHERE user_id=?",
                String.class, userId);
    }
}
