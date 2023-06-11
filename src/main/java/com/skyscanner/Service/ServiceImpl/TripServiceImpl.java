package com.skyscanner.Service.ServiceImpl;

import com.skyscanner.Entity.Trip;
import com.skyscanner.Repository.TripRepository;
import com.skyscanner.Service.TripService;
import com.skyscanner.payload.TripDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.time.LocalDate;
import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;
    private final ModelMapper mapper;
    @Autowired
    public TripServiceImpl(TripRepository tripRepository, ModelMapper modelMapper) {
        this.tripRepository = tripRepository;
        this.mapper = modelMapper;
    }

    @Override
    public TripDto addTrip(TripDto tripDto) {
        Trip trip = new Trip();

        BeanUtils.copyProperties(tripDto, trip);
        Trip savedTrip = tripRepository.save(trip);
        BeanUtils.copyProperties(trip, tripDto);
        return tripDto;

    }

    public List<Trip> searchTrips(String leavingFrom, String goingTo, LocalDate departureDate) {
        return tripRepository.findByLeavingFromAndGoingToAndDepartureDate(leavingFrom, goingTo, departureDate);
    }

}
