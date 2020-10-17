package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {

    @Test
    public void should_return_ticket_when_car_is_park_given_parked_car() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));
        //when
        ParkingTicket ticket = parkingBoy.park(car);
        //then
        assertNotNull(ticket);
    }


    @Test
    public void should_fetch_right_car_when_parking_boy_fetch_given_parking_ticket(){
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));
        ParkingTicket parkingTicket = parkingBoy.park(car);
        //when
        Car fetchedCar = parkingBoy.fetch(parkingTicket);
        //then
        assertSame(car, fetchedCar);
    }

    @Test
    public void should_fetch_2_cars_when_fetch_with_tickets_given_parking_2_cars()  {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));
        ParkingTicket parkingTicket1 = parkingBoy.park(car1);
        ParkingTicket parkingTicket2 = parkingBoy.park(car2);
        //when
        Car fetchedCar1 = parkingBoy.fetch(parkingTicket1);
        Car fetchedCar2 = parkingBoy.fetch(parkingTicket2);
        //then
        assertSame(car1, fetchedCar1);
        assertSame(car2, fetchedCar2);
    }

        @Test
    public void should_fetch_no_car_when_fetch_car_given_wrong_ticket() {
            //given

            Car car = new Car();
            ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));
            ParkingTicket wrongTicket = new ParkingTicket();
            //when
            RuntimeException exception = assertThrows(UnrecognizedTicketException.class, () -> {
                parkingBoy.fetch(wrongTicket);
            });

            //then
            assertEquals("Unrecognized parking ticket", exception.getMessage());
        }

        @Test
    public void should_fetch_no_car_when_fetch_car_given_no_ticket(){
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));
        //when
        Car fetchedCar = parkingBoy.fetch(null);
        //then
            assertNull(fetchedCar);
    }

    @Test
    public void should_fetch_no_car_when_fetch_given_used_ticket() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));
        ParkingTicket parkingTicket = parkingBoy.park(car);
        //when
        Car fetchedCar1 = parkingBoy.fetch(parkingTicket);
        Car fetchedCar = parkingBoy.fetch(parkingTicket);
        //then
        assertNull(fetchedCar);
    }
    
    @Test
    public void should_return_no_ticket_and_park_fail_when_park_given_capacity_is_full() {
        //given
        Car car = new Car();
        Car car2 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        parkingBoy.park(car);
        //when
        ParkingTicket ticket = parkingBoy.park(car2);
        //then
        assertSame(null,ticket);
    }

}

    

