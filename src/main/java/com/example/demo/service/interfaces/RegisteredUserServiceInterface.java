package com.example.demo.service.interfaces;

import com.example.demo.dto.RegisterDataDto;
import com.example.demo.model.RegisteredUser;

import java.util.List;

public interface RegisteredUserServiceInterface {
    List<RegisteredUser> getAllRegUsers();
    RegisteredUser saveUser(RegisteredUser user);
    RegisteredUser findRegByUsername(String username);
    void update(Long id, String username, String password, String email, String firstName, String lastName, String city,
                          String phoneNumber);
}
