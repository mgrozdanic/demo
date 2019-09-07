package com.example.demo.repository;

import com.example.demo.model.AvioCompanyAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminUserRepository  extends JpaRepository<AvioCompanyAdmin, Long> {
    AvioCompanyAdmin findByUserName(String username);
}
