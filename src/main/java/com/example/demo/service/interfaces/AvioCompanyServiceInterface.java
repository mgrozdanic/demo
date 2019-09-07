package com.example.demo.service.interfaces;

import com.example.demo.model.AvioCompany;

public interface AvioCompanyServiceInterface {
    AvioCompany addAvioCompany(AvioCompany avioCompany);
    AvioCompany findByName(String name);
}
