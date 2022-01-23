package com.example.PhotoMap.repository;

import java.util.List;
import java.util.Optional;

public interface DBinterface {
    Object save(Object o);
    Optional<Object> findById(Long id);
    List<Object> findAll();
}
