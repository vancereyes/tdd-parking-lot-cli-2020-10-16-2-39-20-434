package com.oocl.cultivation;

public class ParkingBoy {


    private final ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        return new ParkingTicket();
    }

    public ParkingTicket fetch(Car car) {
        return parkingLot.park(car);
    }
}
