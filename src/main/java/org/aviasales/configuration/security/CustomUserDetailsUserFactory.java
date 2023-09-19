package org.aviasales.configuration.security;

import org.aviasales.entity.Profile;
import org.aviasales.entity.Roles;
import org.aviasales.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetailsUserFactory {

    public CustomUserDetailsUserFactory() {
    }
    public static CustomUserDetailsImpl create(User user, Profile profile){
        return new CustomUserDetailsImpl(
                user.getEmail(),
                user.getPassword(),
                profile.getFirstName(),
                profile.getLastName(),
                profile.getPhone(),
                mapRoleToAuthorities(user.getRoles())
        );
    }
    private static List<? extends GrantedAuthority> mapRoleToAuthorities(List<Roles> userRoles){
        return userRoles.stream()
                .map(role ->  new SimpleGrantedAuthority(role.name().toUpperCase())
                ).collect(Collectors.toList());
    }
}
