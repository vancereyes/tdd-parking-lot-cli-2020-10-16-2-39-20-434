package com.oocl.cultivation.Strategy;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.Exception.NotEnoughCapacity;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;

import java.util.Comparator;
import java.util.List;

public class MoreEmptySlot implements Parking {
    @Override
    public ParkingTicket park(Car car, List<ParkingLot> parkingLotList) {

        return parkingLotList.stream()
                .max(Comparator.comparingInt(ParkingLot::getAvailableCapacity))
                .orElseThrow(() -> new NotEnoughCapacity("Not Enough Capacity"))
                .park(car);
    }
}
