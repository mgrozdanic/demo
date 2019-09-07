package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "layoutitem")
public class LayoutItem  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "layoutitemid", unique = true, nullable = false)
    private Long layoutItemId;
    @ManyToOne
    private Aircraft aircraft;
    @ManyToOne
    private FlightRealisation flightRealisation;
    @ManyToOne
    private RegisteredUser user;
    @Column(name = "seat", nullable = false)
    private int seat;

    public LayoutItem() {
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public FlightRealisation getFlightRealisation() {
        return flightRealisation;
    }

    public void setFlightRealisation(FlightRealisation flightRealisation) {
        this.flightRealisation = flightRealisation;
    }

    public RegisteredUser getUser() {
        return user;
    }

    public void setUser(RegisteredUser user) {
        this.user = user;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getLayoutItemId() {
        return layoutItemId;
    }

    public void setLayoutItemId(Long layoutItemId) {
        this.layoutItemId = layoutItemId;
    }
}
