package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ServiceManagerTest {

    @Test
    public void should_return_1_when_get_list_given_1_parking_boy_to_the_list() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(asList(new ParkingLot()));
        ServiceManager serviceManager = new ServiceManager(asList());
        serviceManager.addToList(parkingBoy);
        //when
        List<ParkingBoy> parkingBoyList = serviceManager.getManagementList();
        ;
        //then
        assertEquals(1, parkingBoyList.size());
    }

    @Test
    public void should_return_a_ticket_when_park_given_service_manager_assigned_parking_boy_to_park() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(asList(new ParkingLot()));
        ServiceManager serviceManager = new ServiceManager(asList());
        serviceManager.addToManagementList(parkingBoy);
        //when
        ParkingTicket parkingTicket = serviceManager.assignToParkCar(parkingBoy, car);
        //then
        assertNotNull(parkingTicket);
    }

}
