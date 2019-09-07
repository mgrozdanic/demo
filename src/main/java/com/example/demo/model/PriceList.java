package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pricelist")
public class PriceList  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pricelistid", unique = true, nullable = false)
    private Long priceListId;
    @ManyToOne
    private AvioCompany avioCompany;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "bussiness", nullable = false)
    private double bussiness;
    @Column(name = "economy", nullable = false)
    private double economy;
    @Column(name = "firstClass", nullable = false)
    private double firstClass;
    @ManyToOne
    private Flight flight;

    public PriceList() {
    }

    public double getBussiness() {
        return bussiness;
    }

    public void setBussiness(double bussiness) {
        this.bussiness = bussiness;
    }

    public double getEconomy() {
        return economy;
    }

    public void setEconomy(double economy) {
        this.economy = economy;
    }

    public double getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(double firstClass) {
        this.firstClass = firstClass;
    }

    public Long getPriceListId() {
        return priceListId;
    }

    public void setPriceListId(Long priceListId) {
        this.priceListId = priceListId;
    }

    public AvioCompany getAvioCompany() {
        return avioCompany;
    }

    public void setAvioCompany(AvioCompany avioCompany) {
        this.avioCompany = avioCompany;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
