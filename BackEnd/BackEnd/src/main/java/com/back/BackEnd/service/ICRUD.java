package com.back.BackEnd.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.lang.reflect.InvocationTargetException;

public interface ICRUD <T, ID>  {

    Page<T> findAll(Pageable pageable);
    T findById (ID id);
    void deleteById(ID id);
    T save(T t);
    T update(T t, ID id) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
}
