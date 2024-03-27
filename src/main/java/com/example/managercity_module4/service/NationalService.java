package com.example.managercity_module4.service;


import com.example.managercity_module4.modal.National;
import com.example.managercity_module4.repository.INationalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NationalService implements INationalService {
    @Autowired
    private INationalRepository nationalRepository;

    public NationalService (INationalRepository nationalRepository){
        this.nationalRepository = nationalRepository;
    }

    @Override
    public List<National> getAllNational() {
        return nationalRepository.findAll();
    }
}
