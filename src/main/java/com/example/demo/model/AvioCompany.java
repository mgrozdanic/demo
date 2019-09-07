package com.example.demo.model;

import com.example.demo.dto.AvioCompanyDto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "aviocompany")
public class AvioCompany  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aviocompanyid", unique = true, nullable = false)
    private Long avioCompanyId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "description", nullable = false)
    private String description;
    //private List<Flight> destinations;
    //private List<FlightRealisation> flights;


    public AvioCompany() {
    }

    public AvioCompany(AvioCompanyDto avioCompanyDto){
        this.name = avioCompanyDto.getName();
        this.address = avioCompanyDto.getAddress();
        this.description = avioCompanyDto.getDescription();
    }

    @Override
    public String toString() {
        return "AvioCompany{" +
                "avioCompanyId=" + avioCompanyId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getAvioCompanyId() {
        return avioCompanyId;
    }

    public void setAvioCompanyId(Long avioCompanyId) {
        this.avioCompanyId = avioCompanyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
