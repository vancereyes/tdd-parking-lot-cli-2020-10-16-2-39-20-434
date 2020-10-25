package com.oocl.cultivation;

import com.oocl.cultivation.Exception.NotEnoughCapacity;
import com.oocl.cultivation.Strategy.CommonFetching;
import com.oocl.cultivation.Strategy.Fetching;

import java.util.List;

public class ParkingBoy {

    public List<ParkingLot> parkingLotArrayList;
    public Fetching fetching;


    public ParkingBoy(List<ParkingLot> parkingLotArrayList) {
        this.parkingLotArrayList = parkingLotArrayList;
        fetching = new CommonFetching();
    }

    public ParkingTicket park(Car car) {

        return parkingLotArrayList.stream()
                .filter(parkingLot -> !parkingLot.isFull())
                .findFirst()
                .orElseThrow(() -> new NotEnoughCapacity("Not enough capacity"))
                .park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return fetching.fetch(parkingTicket, parkingLotArrayList);
    }

    public List<ParkingLot> getParkingLotArrayList() {
        return parkingLotArrayList;
    }
}




