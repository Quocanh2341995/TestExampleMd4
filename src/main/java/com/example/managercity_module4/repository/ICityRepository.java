package com.example.managercity_module4.repository;

import com.example.managercity_module4.modal.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICityRepository extends JpaRepository<City, Long> {
        List<City> findAllByNameContainingIgnoreCase(String name);
}
