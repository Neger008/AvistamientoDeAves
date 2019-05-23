package com.example.AvistamientoDeAves.model;

import lombok.Data;

import java.util.Date;

@Data
public class AvistamientoAves {
    private String birdName;
    private Date sightingDate;
    private Date sightingHour;
    private String referencePlace;
    private int sightingAmount;
    private Person person;
}
