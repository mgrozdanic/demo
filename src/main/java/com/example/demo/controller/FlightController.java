package com.example.demo.controller;

import com.example.demo.dto.AvioCompanyDto;
import com.example.demo.dto.FlightDto;
import com.example.demo.model.AvioCompany;
import com.example.demo.model.Flight;
import com.example.demo.service.interfaces.AvioCompanyServiceInterface;
import com.example.demo.service.interfaces.FlightServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RequestMapping
@RestController
public class FlightController {

    @Autowired
    private FlightServiceInterface flightServiceInterface;

    @Autowired
    private AvioCompanyServiceInterface avioCompanyServiceInterface;

    @RequestMapping(value = "/flight/create", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FlightDto> create(@RequestBody FlightDto flight) {
        Flight f = new Flight();
        AvioCompany company = avioCompanyServiceInterface.findByName(flight.getCompany());
        f.setActive(true);
        f.setAvioCompany(company);
        f.setDistance(flight.getDistance());
        f.setFrom(flight.getFrom());
        f.setTo(flight.getTo());
        f.setFromCode(flight.getFromCode());
        f.setToCode(flight.getToCode());
        //f.setTripLength(flight.getLength());
        Flight added = flightServiceInterface.addFlight(f);
        if (added != null) {
            return new ResponseEntity<>(flight, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @RequestMapping(value = "/flight/getForCompany/{companyName}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FlightDto>> getForCompany(@PathVariable("companyName") String companyName) {
        AvioCompany company = avioCompanyServiceInterface.findByName(companyName);
        List<Flight> flights = flightServiceInterface.getFlightsForCompany(company);
        System.out.println("/////////\n\n" + flights.size() + "\n\n////////////");
        List<FlightDto> flightsDto = new ArrayList<>();
        if (flights != null) {
            for (Flight flight : flights) {
                FlightDto fDto = new FlightDto();
                fDto.setCompany(companyName);
                fDto.setDistance(flight.getDistance());
                fDto.setFrom(flight.getFrom());
                fDto.setTo(flight.getTo());
                fDto.setFromCode(flight.getFromCode());
                fDto.setToCode(flight.getToCode());
                //fDto.setLength(flight.getTripLength());
                flightsDto.add(fDto);
            }
        }
        return new ResponseEntity<>(flightsDto, HttpStatus.OK);
    }


    // dodaj check u ovu funkciju za rezervisane letove, kad uradis
    @RequestMapping(value = "/flight/remove", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FlightDto> remove(@RequestBody FlightDto flight) {
        AvioCompany company = avioCompanyServiceInterface.findByName(flight.getCompany());
        flightServiceInterface.removeFlight(flight.getFrom(), flight.getTo(), flight.getFromCode(), flight.getToCode(),
        company);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }
}