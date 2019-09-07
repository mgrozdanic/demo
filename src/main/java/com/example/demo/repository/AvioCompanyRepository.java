package com.example.demo.repository;

import com.example.demo.model.AvioCompany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvioCompanyRepository extends JpaRepository<AvioCompany, Long> {
    List<AvioCompany> findAll();
    AvioCompany findByName(String name);
}
