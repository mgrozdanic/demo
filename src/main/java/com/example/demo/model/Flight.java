package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "flight")
public class Flight  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flightid", unique = true, nullable = false)
    private Long flightId;
    @ManyToOne(fetch = FetchType.LAZY)
    private AvioCompany avioCompany;// manytoone
    @Column(name = "fromVal", nullable = false)
    private String from;
    @Column(name = "fromcode", nullable = false)
    private String fromCode;
    @Column(name = "toVal", nullable = false)
    private String to;
    @Column(name="tocode", nullable = false)
    private String toCode;
    @Column(name = "distance", nullable = false)
    private double distance;     // kilometers
    @Column(name = "triplength", nullable = false)
    private double tripLength;   // minutes
    @Column(name = "active", nullable = false)
    private boolean active;

    public Flight() {
    }

    public AvioCompany getAvioCompany() {
        return avioCompany;
    }

    public void setAvioCompany(AvioCompany avioCompany) {
        this.avioCompany = avioCompany;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String  from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getTripLength() {
        return tripLength;
    }

    public void setTripLength(double tripLength) {
        this.tripLength = tripLength;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getFromCode() {
        return fromCode;
    }

    public void setFromCode(String fromCode) {
        this.fromCode = fromCode;
    }

    public String getToCode() {
        return toCode;
    }

    public void setToCode(String toCode) {
        this.toCode = toCode;
    }
}
