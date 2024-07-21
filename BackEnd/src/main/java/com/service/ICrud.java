package com.service;

import java.util.List;

public interface ICrud<T, ID> {

    List<T> findAll();

    T update(T t, ID id);

    void delete(ID id);

    T findById(ID id);

    T save(T t);
}
