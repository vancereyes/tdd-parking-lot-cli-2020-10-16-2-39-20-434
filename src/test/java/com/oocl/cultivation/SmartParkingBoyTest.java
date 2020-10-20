package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {

    @Test
    public void should_park_in_more_empty_slot_when_parking_given_parking_1_is_3_and_parking_2_is_4() {
        //given
        Car firstCar = new Car();
        Car secondCar = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(asList(new ParkingLot(3)
                , new ParkingLot(4)));
        //when
        smartParkingBoy.park(firstCar);
        smartParkingBoy.park(secondCar);
        //then
        assertEquals(1, smartParkingBoy.getParkingLotArrayList().get(0).getParkedCarsSize());
        assertEquals(1, smartParkingBoy.getParkingLotArrayList().get(1).getParkedCarsSize());

    }

}
