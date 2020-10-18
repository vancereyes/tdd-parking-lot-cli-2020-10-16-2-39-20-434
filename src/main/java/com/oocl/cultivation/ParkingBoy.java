package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

    private ParkingLot parkingLot;
    private List<ParkingLot> parkingLotArrayList;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingBoy() {
        this(new ParkingLot());
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

//    private void parkIntoLots(Car car) {
//        for (ParkingLot lot : parkingLotArrayList){
//            if (lot.getFreeSlots()>0){
//                    lot.setParkCount();
//                    this.park(car);
//                    break;
//            }
//        }
//    }

//    public int[] getParkingLotCount() {
//        int[] lotSpace = new int[parkingLotArrayList.size()];
//        for (int size = 0 ; size < parkingLotArrayList.size(); size++){
//            lotSpace[size] = parkingLotArrayList.get(size).getCarsParked();
//        }
//        return lotSpace;
//    }
//
    public void setParkingLots(List<ParkingLot> parkingLotArrayList) {
        this.parkingLotArrayList = parkingLotArrayList;
    }

    public List<ParkingLot> getParkingLotArrayList() {
        return parkingLotArrayList;
    }
}




