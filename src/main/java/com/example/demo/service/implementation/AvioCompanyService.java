package com.example.demo.service.implementation;

import com.example.demo.model.AvioCompany;
import com.example.demo.repository.AvioCompanyRepository;
import com.example.demo.service.interfaces.AvioCompanyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvioCompanyService implements AvioCompanyServiceInterface {

    @Autowired
    private AvioCompanyRepository avioCompanyRepository;

    @Override
    public AvioCompany addAvioCompany(AvioCompany avioCompany){
        return avioCompanyRepository.save(avioCompany);
    }

    @Override
    public AvioCompany findByName(String name) {
        return avioCompanyRepository.findByName(name);
    }

}
