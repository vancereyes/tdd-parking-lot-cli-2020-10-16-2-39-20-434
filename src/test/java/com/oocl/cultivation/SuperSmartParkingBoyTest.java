package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperSmartParkingBoyTest {

    @Test
    public void should_park_in_larger_ratio_parking_lot_when_parking_1_has_3_capacity_1_parked_and_parking_2_has_2_capacity_and_no_parked_car() {
        //given
        Car firstCar = new Car();
        Car secondCar = new Car();
        Car thirdCar = new Car();
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(asList(new ParkingLot(3), new ParkingLot(2)));

        //when
        superSmartParkingBoy.park(firstCar);
        superSmartParkingBoy.park(secondCar);
        superSmartParkingBoy.park(thirdCar);
        //then
        assertEquals(2, superSmartParkingBoy.getParkingLotArrayList().get(0).getParkedCarsSize());
        assertEquals(1, superSmartParkingBoy.getParkingLotArrayList().get(1).getParkedCarsSize());
    }
}
