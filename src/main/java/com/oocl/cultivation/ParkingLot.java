package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    private Map<ParkingTicket, Car> ticketCarMap = new HashMap<>();

    public ParkingLot() {
        this(10);
    }

    public boolean isFull(){
        return capacity == getParkedCarsSize();
    }


    public ParkingTicket park(Car car) {
        if (capacity > 0) {
            ParkingTicket ticket = new ParkingTicket();
            ticketCarMap.put(ticket, car);
            capacity -= 1;
            return ticket;
        } else {
            throw new NotEnoughCapacity("Not enough capacity");
        }
    }

    public Car fetch(ParkingTicket parkingTicket){

        Car car = ticketCarMap.get(parkingTicket);
        ticketCarMap.remove(parkingTicket);
        return car;
    }

    public Map<ParkingTicket, Car> getTicketCarMap() {
        return ticketCarMap;
    }

    public int getParkedCarsSize() {
        return ticketCarMap.size();
    }
}


