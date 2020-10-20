package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    private Map<ParkingTicket, Car> ticketCarMap = new HashMap<>();

    public ParkingTicket park(Car car) {

        if(isFull()){
            throw new NotEnoughCapacity("Not enough capacity");
        } else {
            ParkingTicket ticket = new ParkingTicket();
            ticketCarMap.put(ticket, car);
            return ticket;
        }
    }

    public Car fetch(ParkingTicket parkingTicket) {

        Car car = ticketCarMap.get(parkingTicket);
        ticketCarMap.remove(parkingTicket);
        return car;
    }

    public int getParkedCarsSize() {
        return ticketCarMap.size();
    }

    public boolean isFull() {
        return ticketCarMap.size() == capacity;
    }

    public boolean hasTicket(ParkingTicket parkingTicket) {
        return ticketCarMap.containsKey(parkingTicket);
    }
}


