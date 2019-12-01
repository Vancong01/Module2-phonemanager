package com.codegym.service;

import com.codegym.model.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PhoneService {
    Iterable<Phone> findAll();
    Phone findById(Long id);
    void save(Phone phone);
    void remove(Long id);

    //Phân trang
    Page<Phone> findAll(Pageable pageable);
    //Tìm kiếm
    Page<Phone> findAllByNameContaining(String name,Pageable pageable);
}
