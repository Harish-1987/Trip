package com.skyscanner.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "leaving_from")
    private String leavingFrom;

    @Column(name = "going_to")
    private String goingTo;

    @Column(name = "departure_date")
    private LocalDate departureDate;

    @Column(name = "arrival_date")
    private LocalDate arrivalDate;

    @Column(name = "travelers")
    private int travelers;

    @Column(name = "type")
    private String type;

    @Column(name = "seats")
    private int seats;

    @Column(name = "price")
    private double price;

    // Constructors, getters, and setters
    // ...
}
