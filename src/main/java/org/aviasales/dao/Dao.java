package org.aviasales.dao;

import java.util.List;

public interface Dao<T> {
    List<T> getAll(int size, int offset);

    T create(T t) throws Exception;

    T update(T t, Long id);

    void removeById(Long id);

    T findById(Long id);
}
