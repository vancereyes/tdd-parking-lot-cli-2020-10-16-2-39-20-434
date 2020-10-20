package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private static final int DEFAULT_CAPACITY = 10;
    int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    private Map<ParkingTicket, Car> ticketCarMap = new HashMap<>();

    public ParkingLot() {
        this.capacity = DEFAULT_CAPACITY;
    }

    public ParkingTicket park(Car car) {

        if (isFull()) {
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


    public int getAvailableCapacity() {
        return capacity - getParkedCarsSize();
    }

    public double getCapacityRate() {
        return (double) getAvailableCapacity() / capacity;
    }
}


