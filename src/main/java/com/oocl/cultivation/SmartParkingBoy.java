package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(List<ParkingLot> parkingLotArrayList) {
        super(parkingLotArrayList);
    }

    @Override
    public ParkingTicket park(Car car) {

        return  parkingLotArrayList.stream()
                .max(Comparator.comparingInt(ParkingLot::getAvailableCapacity))
                .orElseThrow(()->new NotEnoughCapacity("Not Enough Capacity"))
                .park(car);
    }
}
