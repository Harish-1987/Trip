package com.skyscanner.payload;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripDto {
    private Long id;
    private String leavingFrom;
    private String goingTo;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private int travelers;
    private String type;
    private int seats;
    private double price;

}
