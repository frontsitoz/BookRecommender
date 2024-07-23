package com.back.BackEnd.service.impl;

import com.back.BackEnd.exception.ModelNotFoundException;
import com.back.BackEnd.repository.IGenericRepo;
import com.back.BackEnd.service.ICRUD;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class CRUDImpl <T, ID> implements ICRUD<T, ID> {

    public abstract IGenericRepo<T, ID> getRepo();

    @Override
    public Page<T> findAll(Pageable pageable) {

        return getRepo().findAll(pageable);
    }

    @Override
    public T findById(ID id) {

        return getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("Id not found "+ id));
    }

    @Override
    public void deleteById(ID id) {

        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("Id not found "+id));
        getRepo().deleteById(id);
    }

    @Override
    public T save(T t) {

        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("Id not found "+id));
        Class<?> clazz = t.getClass();
        String nameMethod = "setId" + clazz.getSimpleName();
        Method method = clazz.getMethod(nameMethod, id.getClass());
        method.invoke(t, id);

        return getRepo().save(t);
    }
}
