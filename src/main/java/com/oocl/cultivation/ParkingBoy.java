package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {

    protected List<ParkingLot> parkingLotArrayList;

    public ParkingBoy(List<ParkingLot> parkingLotArrayList) {

        this.parkingLotArrayList = parkingLotArrayList;
    }


    public ParkingTicket park(Car car) {

        return parkingLotArrayList.stream()
                .filter(parkingLot -> !parkingLot.isFull())
                .findFirst()
                .orElseThrow(() -> new NotEnoughCapacity("Not enough capacity"))
                .park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        boolean noTicket = (parkingTicket == null);

        if(noTicket){
            throw new MissingTicketException("Missing ticket");
        } else {
            return parkingLotArrayList.stream()
                    .filter(parkingLot -> parkingLot.hasTicket(parkingTicket))
                    .findFirst()
                    .orElseThrow(() -> new UnrecognizedTicketException("Unrecognized parking ticket"))
                    .fetch(parkingTicket);
        }
    }

    public List<ParkingLot> getParkingLotArrayList() {
        return parkingLotArrayList;
    }
}




