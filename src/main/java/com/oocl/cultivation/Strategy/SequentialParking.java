package com.oocl.cultivation.Strategy;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.Exception.NotEnoughCapacity;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;

import java.util.List;

public class SequentialParking implements Parking {
    @Override
    public ParkingTicket park(Car car, List<ParkingLot> parkingLotList) {
        return parkingLotList.stream()
                .filter(parkingLot -> !parkingLot.isFull())
                .findFirst()
                .orElseThrow(() -> new NotEnoughCapacity("Not enough capacity"))
                .park(car);
    }
}
