package org.aviasales.service.impl;

import org.aviasales.configuration.security.CustomUserDetailsImpl;
import org.aviasales.configuration.security.CustomUserDetailsUserFactory;
import org.aviasales.dao.ProfileDao;
import org.aviasales.dao.RoleDao;
import org.aviasales.dao.UserDao;
import org.aviasales.entity.Profile;
import org.aviasales.entity.Roles;
import org.aviasales.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

    private final UserDao userDao;
    private final ProfileDao profileDao;
    private final RoleDao roleDao;

    public SecurityUserDetailsService(UserDao userDao, ProfileDao profileDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.profileDao = profileDao;
        this.roleDao = roleDao;
    }


    @Override
    public CustomUserDetailsImpl loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        user.setRoles(Arrays.asList(Roles.valueOf(roleDao.findByUserId(user.getUserId()))));
        Profile profile = profileDao.getProfileByUserId(user.getUserId());
        return CustomUserDetailsUserFactory.create(user, profile);
    }
}
