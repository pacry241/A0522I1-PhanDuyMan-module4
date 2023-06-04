package vn.codegym.service;

import vn.codegym.model.Customer;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();
    T findById(Long id);
    void save(T t);
    void remove(Long id);
    boolean insertWithStoredProcedure(T t);
}
