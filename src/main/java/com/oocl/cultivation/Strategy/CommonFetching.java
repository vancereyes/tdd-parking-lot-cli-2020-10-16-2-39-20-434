package com.oocl.cultivation.Strategy;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.Exception.MissingTicketException;
import com.oocl.cultivation.Exception.UnrecognizedTicketException;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;

import java.util.List;

public class CommonFetching implements Fetching {

    @Override
    public Car fetch(ParkingTicket parkingTicket, List<ParkingLot> parkingLots) {
        boolean noTicket = (parkingTicket == null);
        if (noTicket) {
            throw new MissingTicketException("Missing ticket");
        } else {
            return parkingLots.stream()
                    .filter(parkingLot -> parkingLot.hasTicket(parkingTicket))
                    .findFirst()
                    .orElseThrow(() -> new UnrecognizedTicketException("Unrecognized parking ticket"))
                    .fetch(parkingTicket);
        }
    }
}
