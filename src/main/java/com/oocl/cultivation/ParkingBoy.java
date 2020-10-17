package com.oocl.cultivation;

public class ParkingBoy {

    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }


    public ParkingTicket park(Car car) {
        return parkingLot.park(car);
    }


    public Car fetch(ParkingTicket parkingTicket) {
        Car car = parkingLot.fetch(parkingTicket);
        if (car != null) {
            return car;
        } else if (parkingTicket == null){
            throw new MissingTicketException("Missing ticket");
        } else {
            throw new UnrecognizedTicketException("Unrecognized parking ticket");
        }
    }

}

