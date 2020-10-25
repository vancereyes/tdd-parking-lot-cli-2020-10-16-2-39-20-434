package com.oocl.cultivation;

import com.oocl.cultivation.Exception.NotEnoughCapacity;
import com.oocl.cultivation.Strategy.CommonFetching;
import com.oocl.cultivation.Strategy.Fetching;
import com.oocl.cultivation.Strategy.Parking;
import com.oocl.cultivation.Strategy.SequentialParking;

import java.util.List;

public class ParkingBoy {

    public List<ParkingLot> parkingLotArrayList;
    public Fetching fetching;
    public Parking parking;


    public ParkingBoy(List<ParkingLot> parkingLotArrayList) {
        this.parkingLotArrayList = parkingLotArrayList;
        fetching = new CommonFetching();
        parking = new SequentialParking();
    }

    public ParkingTicket park(Car car) {
        return parking.park(car, parkingLotArrayList);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return fetching.fetch(parkingTicket, parkingLotArrayList);
    }

    public List<ParkingLot> getParkingLotArrayList() {
        return parkingLotArrayList;
    }
}




