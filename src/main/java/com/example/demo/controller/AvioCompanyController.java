package com.example.demo.controller;


import com.example.demo.dto.AvioCompanyDto;
import com.example.demo.model.AvioCompany;
import com.example.demo.service.interfaces.AvioCompanyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping
@RestController
public class AvioCompanyController {

    @Autowired
    private AvioCompanyServiceInterface avioCompanyServiceInterface;

    //------------------create avio company--------------------------------------------------

    @RequestMapping(value = "/aviocompany/create",method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AvioCompany> create(@RequestBody AvioCompanyDto avioCompanyDto){
        AvioCompany avioCompany = new AvioCompany(avioCompanyDto);
        AvioCompany newAvioCompany = avioCompanyServiceInterface.addAvioCompany(avioCompany);
        //Test
        System.out.println(newAvioCompany);

        return new ResponseEntity<>(newAvioCompany, HttpStatus.CREATED);
    }

}
