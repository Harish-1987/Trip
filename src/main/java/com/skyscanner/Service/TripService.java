package com.skyscanner.Service;

import com.skyscanner.Entity.Trip;
import com.skyscanner.payload.TripDto;

import java.time.LocalDate;
import java.util.List;

public interface TripService {
    TripDto addTrip(TripDto tripDto);

    List<Trip> searchTrips(String leavingFrom, String goingTo, LocalDate departureDate);
}
