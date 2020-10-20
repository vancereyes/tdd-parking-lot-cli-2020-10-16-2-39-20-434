package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(List<ParkingLot> parkingLotArrayList) {
        super(parkingLotArrayList);
    }

    @Override
    public ParkingTicket park(Car car) {
        return parkingLotArrayList.stream()
                .max(Comparator.comparingDouble(ParkingLot::getCapacityRate))
                .orElseThrow(() -> new NotEnoughCapacity("Not Enough Capacity"))
                .park(car);
    }
}
