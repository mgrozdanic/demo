package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "flightrealisation")
public class FlightRealisation  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flightrealisationid", unique = true, nullable = false)
    private Long flightRealisationId;

    @ManyToOne
    private Flight flight;
    //private LayoutItem layout;          // <-- current aircraft state here
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalDate;
    @ManyToOne
    private PriceList priceList;

    public FlightRealisation() {
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public PriceList getPrice() {
        return priceList;
    }

    public void setPrice(PriceList priceList) {
        this.priceList = priceList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getFlightRealisationId() {
        return flightRealisationId;
    }

    public void setFlightRealisationId(Long flightRealisationId) {
        this.flightRealisationId = flightRealisationId;
    }


    public PriceList getPriceList() {
        return priceList;
    }

    public void setPriceList(PriceList priceList) {
        this.priceList = priceList;
    }
}
