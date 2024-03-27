package com.example.managercity_module4.service;


import com.example.managercity_module4.modal.City;
import com.example.managercity_module4.repository.ICityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityService implements ICityService {
    private final ICityRepository cityRepository;


    @Override
    public List<City> getAllCity() {
        return cityRepository.findAll();
    }

    @Override
    public List<City> getAllCityBy(String search) {
        return cityRepository.findAllByNameContainingIgnoreCase(search);
    }

    @Override
    public City getDetailCityBy(Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Thanh pho khong tim thay."));
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void deletedBy(Long id) throws Exception {
        try{
            cityRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Không thể xóa dữ liệu của city: " + e.getMessage());
        }
    }
}
