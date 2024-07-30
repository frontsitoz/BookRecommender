package com.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ICRUD <T, ID>  {

    List<T> findAll();
    T findById (ID id);
    void deleteById(ID id);
    T save(T t);
    T update(T t, ID id) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
}
