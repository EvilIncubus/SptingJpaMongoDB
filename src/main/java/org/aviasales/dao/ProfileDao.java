package org.aviasales.dao;

import org.aviasales.entity.Profile;

public interface ProfileDao {
    Profile getProfileByUserId(int userId);
}
