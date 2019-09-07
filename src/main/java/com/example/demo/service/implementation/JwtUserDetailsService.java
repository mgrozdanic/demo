package com.example.demo.service.implementation;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.AvioCompanyAdmin;
import com.example.demo.model.RegisteredUser;
import com.example.demo.repository.AdminUserRepository;
import com.example.demo.repository.RegisteredUserRepository;
import com.example.demo.service.interfaces.AdminUserServiceInterface;
import com.example.demo.service.interfaces.RegisteredUserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService, AdminUserServiceInterface, RegisteredUserServiceInterface {

    @Autowired
    private RegisteredUserRepository regUserRepo;
    @Autowired
    private AdminUserRepository adminUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        RegisteredUser registeredUser = regUserRepo.findByUserName(username);
        AvioCompanyAdmin avioCompanyAdmin = adminUserRepo.findByUserName(username);

        if (registeredUser != null){
            //do stuff, return
            return new org.springframework.security.core.userdetails.User(registeredUser.getUserName(), registeredUser.getPassword(),
                    new ArrayList<>());
        }
        if (avioCompanyAdmin != null){
            //do stuff, return
            return new org.springframework.security.core.userdetails.User(avioCompanyAdmin.getUserName(), avioCompanyAdmin.getPassword(),
                    new ArrayList<>());
        }

        throw new UsernameNotFoundException("User not found with username: " + username);
        /*if ("javainuse".equals(username)) {
            return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }*/
    }

    @Override
    public List<AvioCompanyAdmin> getAllAdmins(){
        return adminUserRepo.findAll();
    }

    @Override
    public AvioCompanyAdmin findAdminByUsername(String username) {
        return adminUserRepo.findByUserName(username);
    }


    @Override
    public List<RegisteredUser> getAllRegUsers(){
        return regUserRepo.findAll();
    }

    @Override
    public RegisteredUser saveUser(RegisteredUser user) {
        regUserRepo.save(user);
        return null;
    }

    @Override
    public RegisteredUser findRegByUsername(String username) {
        return regUserRepo.findByUserName(username);
    }

    @Override
    public void update(Long id, String username, String password, String email, String firstName, String lastName, String city, String phoneNumber) {
        regUserRepo.updateUser(id, username, password, email, firstName, lastName, city, phoneNumber);
    }

}