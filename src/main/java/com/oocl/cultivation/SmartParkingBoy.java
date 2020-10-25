package com.oocl.cultivation;

import com.oocl.cultivation.Exception.NotEnoughCapacity;
import com.oocl.cultivation.Strategy.MoreEmptySlot;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(List<ParkingLot> parkingLotArrayList) {
        super(parkingLotArrayList);
        parking = new MoreEmptySlot();
    }

    @Override
    public ParkingTicket park(Car car) {
    return parking.park(car, parkingLotArrayList);
    }
}
