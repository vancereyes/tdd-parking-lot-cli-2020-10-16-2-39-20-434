package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {

    private List<ParkingLot> parkingLotArrayList;

    public ParkingBoy(List<ParkingLot> parkingLotArrayList) {

        this.parkingLotArrayList = parkingLotArrayList;
    }



    public ParkingTicket park(Car car) {

        return parkingLotArrayList.stream()
                .filter(parkingLot -> !parkingLot.isFull())
                .findFirst()
                .orElseThrow(() -> new NotEnoughCapacity("Not enough capacity"))
                .park(car);


//        for (ParkingLot parkingLot : parkingLotArrayList) { //streamapi
//            if (!parkingLot.isFull()) {
//                return parkingLot.park(car);
//            }
//        }
//        return null;
//    }


//    public Car fetch(ParkingTicket parkingTicket) {
//        Car car = parkingLotArrayList.get(0).fetch(parkingTicket); //refactor
//        if (car != null) {
//            return car;
//        } else if (parkingTicket == null) { //25
//            throw new MissingTicketException("Missing ticket");
//        } else {
//            throw new UnrecognizedTicketException("Unrecognized parking ticket");
//        }
//    }
//
//    public List<ParkingLot> getParkingLotArrayList() {
//        return parkingLotArrayList;
//    }
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
}




