package com.example.managercity_module4.service;

import com.example.managercity_module4.modal.City;

import java.util.List;

public interface ICityService {
    List<City> getAllCity();
    List<City> getAllCityBy(String search);
    City getDetailCityBy(Long id);
    void save(City city);
    void deletedBy(Long id) throws Exception;

}
