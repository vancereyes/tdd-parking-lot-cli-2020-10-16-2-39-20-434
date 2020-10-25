package com.oocl.cultivation;

import com.oocl.cultivation.Strategy.HigherRatioParking;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(List<ParkingLot> parkingLotArrayList) {
        super(parkingLotArrayList);
        parking = new HigherRatioParking();
    }

    @Override
    public ParkingTicket park(Car car) {
        return parking.park(car, parkingLotArrayList);
    }
}
