package org.aviasales.service.impl;

import org.aviasales.dao.AirplaneDao;
import org.aviasales.dao.FlightDao;
import org.aviasales.dao.FlightManagementDao;
import org.aviasales.dao.SeatDao;
import org.aviasales.dto.FlightManagementDTO;
import org.aviasales.entity.*;
import org.aviasales.service.FlightManagementService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightManagementServiceImpl implements FlightManagementService {

    private final FlightManagementDao flightManagementDao;
    private final FlightDao flightDao;
    private final SeatDao seatDao;
    private final AirplaneDao airplaneDao;

    public FlightManagementServiceImpl(FlightManagementDao flightManagementDao, FlightDao flightDao, SeatDao seatDao, AirplaneDao airplaneDao) {
        this.flightManagementDao = flightManagementDao;
        this.flightDao = flightDao;
        this.seatDao = seatDao;
        this.airplaneDao = airplaneDao;
    }

    @Override
    public void createFlightManagement(FlightManagementDTO flightManagementDTO) {
        FlightManagement flightManagement = flightManagementDTO.getFlightManagement();

        List<Seat> seatsFrom = generateSeats(flightManagement.getDestinationFlight(), flightManagementDTO.getEconomySeats(), flightManagementDTO.getPriceEconomySeat(), SeatType.ECONOMY);
        seatsFrom.addAll(generateSeats(flightManagement.getDestinationFlight(), flightManagementDTO.getBusinessSeats(), flightManagementDTO.getPriceBusinessSeat(), SeatType.BUSINESS));
        flightManagement.getDestinationFlight().setSeats(seatsFrom);

        List<Seat> seatsTo = generateSeats(flightManagement.getOriginFlight(), flightManagementDTO.getEconomySeats(), flightManagementDTO.getPriceEconomySeat(), SeatType.ECONOMY);
        seatsTo.addAll(generateSeats(flightManagement.getOriginFlight(), flightManagementDTO.getBusinessSeats(), flightManagementDTO.getPriceBusinessSeat(), SeatType.BUSINESS));
        flightManagement.getOriginFlight().setSeats(seatsTo);

        try {
            flightManagement.setDestinationFlight(flightDao.create(flightManagement.getDestinationFlight()));


            flightManagement.setOriginFlight(flightDao.create(flightManagement.getOriginFlight()));

            for (Seat seat : flightManagement.getDestinationFlight().getSeats()) {
                seatDao.create(seat);
            }
            for (Seat seat : flightManagement.getOriginFlight().getSeats()) {
                seatDao.create(seat);
            }
            flightManagementDao.create(flightManagement);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Page<FlightManagement> getListFlightManagement(int page, int size) {
        return new Page<>(flightManagementDao.getAll(size, (page - 1) * size), flightManagementDao.countFlightManagement(), page, size);
    }

    @Override
    public Page<Airplane> getAirplanes() {
        return new Page<>(airplaneDao.getAll(10, 0), airplaneDao.countFlightManagement(), 0, 10);
    }

    private List<Seat> generateSeats(Flight flight, int amountSeats, double priceSeats, SeatType type){
        List<Seat> seats = new ArrayList<>();
        for (int i = 0; i < amountSeats; i++) {
            Seat seat = new Seat();
            seat.setFlightId(flight.getFlightId());
            seat.setPriceSeat(priceSeats);
            seat.setSeatType(type);
            seat.setAvailablePlace(true);
            seat.setPlaceNumber(i);
            seats.add(seat);
        }
        return seats;
    }
}
