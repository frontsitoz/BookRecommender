package com.service.impl;

import com.books.repository.IGenericRepo;
import com.books.service.ICrud;

import java.util.List;

public abstract class CrudImpl <T,ID> implements ICrud<T, ID> {

    public abstract IGenericRepo<T, ID> getRepo();

    @Override
    public List<T> findAll() {
        return getRepo().findAll();
    }
    @Override
    public T save(T t) {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) {
        return getRepo().save(t);
        //Asignar el id al objeto
    }

    @Override
    public void delete(ID id) {
        getRepo().deleteById(id);
    }

    @Override
    public T findById(ID id) {
        return getRepo().findById(id).orElse(null);
        //manejo de excepciones
    }
}
