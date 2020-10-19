package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {

    private List<ParkingLot> parkingLotArrayList;

    public ParkingBoy(List<ParkingLot> parkingLotArrayList) {
        this.parkingLotArrayList = parkingLotArrayList;
    }

    public ParkingTicket park(Car car) {

        for (ParkingLot parkingLot : parkingLotArrayList) { //streamapi
            if (!parkingLot.isFull()){
                return parkingLot.park(car);
            }
        }
        return null;

    }

    public Car fetch(ParkingTicket parkingTicket) {
        Car car = parkingLotArrayList.get(0).fetch(parkingTicket); //refactor
        if (car != null) {
            return car;
        } else if (parkingTicket == null){
            throw new MissingTicketException("Missing ticket");
        } else {
            throw new UnrecognizedTicketException("Unrecognized parking ticket");
        }
    }

    public List<ParkingLot> getParkingLotArrayList() {
        return parkingLotArrayList;
    }
}




