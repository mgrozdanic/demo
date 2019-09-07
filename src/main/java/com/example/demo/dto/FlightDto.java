package com.example.demo.dto;

public class FlightDto {
    private String from;
    private String fromCode;
    private String to;
    private String toCode;
    private double distance;
    //private double length;
    private String company;

    public FlightDto() {
    }

    public FlightDto(String from, String fromCode, String to, String toCode, double distance, String company) {
        this.from = from;
        this.fromCode = fromCode;
        this.to = to;
        this.toCode = toCode;
        this.distance = distance;
        //this.length = length;
        this.company = company;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFromCode() {
        return fromCode;
    }

    public void setFromCode(String fromCode) {
        this.fromCode = fromCode;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getToCode() {
        return toCode;
    }

    public void setToCode(String toCode) {
        this.toCode = toCode;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    /*public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }*/

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
