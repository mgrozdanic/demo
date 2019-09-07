package com.example.demo.service.interfaces;

import com.example.demo.model.AvioCompanyAdmin;

import java.util.List;

public interface AdminUserServiceInterface {
    List<AvioCompanyAdmin> getAllAdmins();
    AvioCompanyAdmin findAdminByUsername(String username);
}
