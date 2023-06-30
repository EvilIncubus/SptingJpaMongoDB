package org.aviasales.service.impl;

import org.aviasales.dao.FlightDao;
import org.aviasales.dao.FlightManagementDao;
import org.aviasales.dao.SeatDao;
import org.aviasales.dto.FlightManagementDTO;
import org.aviasales.entity.Flight;
import org.aviasales.entity.FlightManagement;
import org.aviasales.entity.Seat;
import org.aviasales.entity.SeatType;
import org.aviasales.service.FlightManagementService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightManagementManagementServiceImpl implements FlightManagementService {

    private final FlightManagementDao flightManagementDao;
    private final FlightDao flightDao;
    private final SeatDao seatDao;

    public FlightManagementManagementServiceImpl(FlightManagementDao flightManagementDao, FlightDao flightDao, SeatDao seatDao) {
        this.flightManagementDao = flightManagementDao;
        this.flightDao = flightDao;
        this.seatDao = seatDao;
    }


    @Override
    public void createFlight(FlightManagementDTO flightManagementDTO) {
        FlightManagement flightManagement = flightManagementDTO.getFlightManagement();

        List<Seat> seatsFrom = generateSeats(flightManagement.getFlightFrom(), flightManagementDTO.getEconomySeats(), flightManagementDTO.getPriceEconomySeat());
        seatsFrom.addAll(generateSeats(flightManagement.getFlightFrom(), flightManagementDTO.getBusinessSeats(), flightManagementDTO.getPriceBusinessSeat()));
        flightManagement.getFlightFrom().setSeats(seatsFrom);

        List<Seat> seatsTo = generateSeats(flightManagement.getFlightTo(), flightManagementDTO.getEconomySeats(), flightManagementDTO.getPriceEconomySeat());
        seatsTo.addAll(generateSeats(flightManagement.getFlightTo(), flightManagementDTO.getBusinessSeats(), flightManagementDTO.getPriceBusinessSeat()));
        flightManagement.getFlightTo().setSeats(seatsTo);

        flightManagement.setFlightFrom(flightDao.create(flightManagement.getFlightFrom()));
        flightManagement.setFlightTo(flightDao.create(flightManagement.getFlightTo()));

        for (Seat seat : flightManagement.getFlightFrom().getSeats()){
            seatDao.create(seat);
        }
        for (Seat seat : flightManagement.getFlightTo().getSeats()){
            seatDao.create(seat);
        }
        flightManagementDao.create(flightManagement);
    }

    private List<Seat> generateSeats(Flight flight, int amountSeats, double priceSeats){
        List<Seat> seats = new ArrayList<>();
        for (int i = 0; i < amountSeats; i++) {
            Seat seat = new Seat();
            seat.setFlightId(flight.getFlightId());
            seat.setPriceSeat(priceSeats);
            seat.setSeatType(SeatType.ECONOMY);
            seat.setAvailablePlace(true);
            seat.setPlaceNumber(i);
            seats.add(seat);
        }
        return seats;
    }
}
