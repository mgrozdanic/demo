package com.example.demo.controller;

import com.example.demo.dto.DTO;
import com.example.demo.dto.LoginDataDto;
import com.example.demo.dto.RegisterDataDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.*;
import com.example.demo.security.JwtTokenUtil;
import com.example.demo.service.implementation.JwtUserDetailsService;
import com.example.demo.service.interfaces.AdminUserServiceInterface;
import com.example.demo.service.interfaces.RegisteredUserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RequestMapping
@RestController
public class UsersController {

    @Autowired private RegisteredUserServiceInterface regUserService;
    @Autowired private AdminUserServiceInterface adminUserService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/users/modifyUser",method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> modifyUser(@RequestBody DTO dto){
        UserDto user = dto.user;
        String oldUsername = dto.oldUserName;
        RegisteredUser thisUser = regUserService.findRegByUsername(oldUsername);
        RegisteredUser duplicate = null;
        if (!oldUsername.equals(user.getUserName())){
            duplicate = regUserService.findRegByUsername(user.getUserName());
        }
        if (duplicate == null){
            regUserService.update(thisUser.getRegisteredUserId(), user.getUserName(), passwordEncoder.encode(
                    user.getPassword()), user.getEmail(), user.getFirstName(),
            user.getLastName(), user.getCity(), user.getPhoneNumber());
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(new UserDto("taken", "", "", "", "","", "",
                "", "", ""), HttpStatus.OK);
    }


    @RequestMapping(value = "/users/getLoggedUser",method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getLoggedUser(@RequestBody LoginDataDto authenticationRequest) throws Exception {
        RegisteredUser registeredUser = regUserService.findRegByUsername(authenticationRequest.getUsername());
        AvioCompanyAdmin avioCompanyAdmin = adminUserService.findAdminByUsername(authenticationRequest.getUsername());


        //dodaj sutra
        if (!(registeredUser == null)) {
            if (!passwordEncoder.matches(authenticationRequest.getPassword(), registeredUser.getPassword())) {
                registeredUser = null;
            }
        }

        if (!(avioCompanyAdmin == null)) {
            if (!passwordEncoder.matches(authenticationRequest.getPassword(), avioCompanyAdmin.getPassword())) {
                avioCompanyAdmin = null;
            }
        }
        if (avioCompanyAdmin == null && registeredUser == null){
            return new ResponseEntity<>(new UserDto("notMatching", "", "", "", ""
                    , "", "", "", "", ""), HttpStatus.OK);
        }

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        if (registeredUser != null) {
            return new ResponseEntity<>(new UserDto("regUser", registeredUser.getUserName(),
                    registeredUser.getEmail(), authenticationRequest.getPassword(), registeredUser.getCity(), registeredUser.getLastName()
                    , registeredUser.getFirstName(), registeredUser.getPhoneNumber(), "", token), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(new UserDto("adminUser", avioCompanyAdmin.getUserName(), avioCompanyAdmin.getEmail()
                    , authenticationRequest.getPassword(), "", "", "", "",
                    avioCompanyAdmin.getEmloyer().getName(), token), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/users/registerUser",method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@RequestBody RegisterDataDto authenticationRequest) throws Exception {

        List<RegisteredUser> users = regUserService.getAllRegUsers();
        for (RegisteredUser r : users) {
            if (r.getUserName().equals(authenticationRequest.getUserName())){
                return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
            }
        }
        RegisteredUser newUser = new RegisteredUser();
        newUser.setUserName(authenticationRequest.getUserName());
        newUser.setPassword(passwordEncoder.encode(authenticationRequest.getPassword()));
        //newUser.setPassword(authenticationRequest.getPassword());
        newUser.setEmail(authenticationRequest.getEmail());
        newUser.setCity(authenticationRequest.getCity());
        newUser.setFirstName(authenticationRequest.getFirstName());
        newUser.setLastName(authenticationRequest.getLastName());
        newUser.setPhoneNumber(authenticationRequest.getPhoneNumber());
        regUserService.saveUser(newUser); // dodaj usera
        //da ne salje gluposti
        newUser.setPassword(authenticationRequest.getPassword());

        /*
        authenticate(authenticationRequest.getUserName(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUserName());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));*/
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
