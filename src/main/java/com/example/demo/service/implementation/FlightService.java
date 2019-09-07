package com.example.demo.service.implementation;

import com.example.demo.model.AvioCompany;
import com.example.demo.model.Flight;
import com.example.demo.repository.FlightRepository;
import com.example.demo.service.interfaces.FlightServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService implements FlightServiceInterface {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> getFlightsForCompany(AvioCompany id) {
        return flightRepository.findAllByCompany(id);
    }

    @Override
    public void removeFlight(String from, String to, String fromCode, String toCode, AvioCompany avioCompany) {
        flightRepository.removeFlight(from, to, fromCode, toCode, avioCompany);
    }
}
