package com.skyscanner.Controller;

import com.skyscanner.Entity.Trip;
import com.skyscanner.payload.TripDto;
import com.skyscanner.Service.TripService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripController {

    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    //                http://localhost:8080/trips
    @PostMapping
    public ResponseEntity<TripDto> addTrip(@RequestBody TripDto tripDto) {
        TripDto addedTrip = tripService.addTrip(tripDto);
        return new ResponseEntity<>(addedTrip, HttpStatus.CREATED);
    }

    //             http://localhost:8080/trips/search?leavingFrom=Chicago&goingTo=Miami&departureDate=2023-07-01
    @GetMapping("/search")
    public ResponseEntity<List<TripDto>> searchTrips(
            @RequestParam("leavingFrom") String leavingFrom,
            @RequestParam("goingTo") String goingTo,
            @RequestParam("departureDate") String departureDate
    ) {
        LocalDate departure = LocalDate.parse(departureDate.trim());
        List<Trip> trips = tripService.searchTrips(leavingFrom, goingTo, departure);
        List<TripDto> tripDtos = convertToDtos(trips);
        return new ResponseEntity<>(tripDtos, HttpStatus.OK);
    }



    private List<TripDto> convertToDtos(List<Trip> tripEntities) {
        List<TripDto> tripDtos = new ArrayList<>();

        for (Trip tripEntity : tripEntities) {
            TripDto tripDto = new TripDto();
            BeanUtils.copyProperties(tripEntity, tripDto);
            tripDtos.add(tripDto);
        }

        return tripDtos;
    }
}




//        BeanUtils.copyProperties(userDTO, user);        OR
//        BeanUtils.copyProperties(user, userDTO);
