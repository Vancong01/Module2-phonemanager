package com.codegym.service;

import com.codegym.model.Phone;

public interface PhoneService {
    Iterable<Phone> findAll();
    Phone findById(Long id);
    void save(Phone phone);
    void remove(Long id);
}
