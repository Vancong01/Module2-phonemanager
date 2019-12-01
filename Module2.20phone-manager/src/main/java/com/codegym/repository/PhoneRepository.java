package com.codegym.repository;

import com.codegym.model.Phone;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PhoneRepository extends PagingAndSortingRepository<Phone,Long> {
}
