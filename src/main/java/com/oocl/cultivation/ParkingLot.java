package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {


    int capacity = 10;


    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    private Map<ParkingTicket, Car> ticketCarMap = new HashMap<>();
    public ParkingTicket park(Car car) {
        if (capacity > 0) {
            ParkingTicket ticket = new ParkingTicket();
            ticketCarMap.put(ticket, car);
            capacity -= 1;
            return ticket;
        } return null;
    }

    public Car fetch(ParkingTicket parkingTicket){

        Car car = ticketCarMap.get(parkingTicket);
        ticketCarMap.remove(parkingTicket);
        return car;
    }

}


