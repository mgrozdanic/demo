package com.example.demo.service.interfaces;

import com.example.demo.model.AvioCompany;
import com.example.demo.model.Flight;

import java.util.List;

public interface FlightServiceInterface {
    Flight addFlight(Flight flight);
    List<Flight> getFlightsForCompany(AvioCompany id);
    void removeFlight(String from, String to, String fromCode, String toCode, AvioCompany avioCompany);
}
