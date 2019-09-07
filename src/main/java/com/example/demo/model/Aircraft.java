package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "aircraft")
public class Aircraft  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aircraftid", unique = true, nullable = false)
    private Long aircraftId;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "identifier", nullable = false)
    private String identifier;
    @ManyToOne
    private AvioCompany aircraftOwner;
    @Column(name = "rowsno", nullable = false)
    private int rowsNo;
    @Column(name = "columnsno", nullable = false)
    private int columnsNo;
    @ElementCollection
    @CollectionTable(name="gaps", joinColumns=@JoinColumn(name="aircraftid"))
    @Column(name="gap")
    private List<Integer> gaps;
    @ElementCollection
    @CollectionTable(name="firstclass", joinColumns=@JoinColumn(name="aircraftid"))
    @Column(name="fclass")
    private List<Integer> firstClass;
    @ElementCollection
    @CollectionTable(name="bussiness", joinColumns=@JoinColumn(name="aircraftid"))
    @Column(name="bness")
    private List<Integer> bussiness;
    @ElementCollection
    @CollectionTable(name="removedseats", joinColumns=@JoinColumn(name="aircraftid"))
    @Column(name="rseats")
    private List<Integer> removedSeats;

    public Aircraft() {
    }

    public AvioCompany getAircraftOwner() {
        return aircraftOwner;
    }

    public void setAircraftOwner(AvioCompany aircraftOwner) {
        this.aircraftOwner = aircraftOwner;
    }

    public int getRowsNo() {
        return rowsNo;
    }

    public void setRowsNo(int rowsNo) {
        this.rowsNo = rowsNo;
    }

    public int getColumnsNo() {
        return columnsNo;
    }

    public void setColumnsNo(int columnsNo) {
        this.columnsNo = columnsNo;
    }

    public List<Integer> getGaps() {
        return gaps;
    }

    public void setGaps(List<Integer> gaps) {
        this.gaps = gaps;
    }

    public List<Integer> getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(List<Integer> firstClass) {
        this.firstClass = firstClass;
    }

    public List<Integer> getBussiness() {
        return bussiness;
    }

    public void setBussiness(List<Integer> bussiness) {
        this.bussiness = bussiness;
    }

    public List<Integer> getRemovedSeats() {
        return removedSeats;
    }

    public void setRemovedSeats(List<Integer> removedSeats) {
        this.removedSeats = removedSeats;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(Long aircraftId) {
        this.aircraftId = aircraftId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
