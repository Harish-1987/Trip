package com.skyscanner.Repository;

import com.skyscanner.Entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByLeavingFromAndGoingToAndDepartureDate(String leavingFrom, String goingTo, LocalDate departureDate);

}


//Instead of findBy you can also use SearchBy
