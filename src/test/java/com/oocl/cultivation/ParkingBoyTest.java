package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {

    @Test
    public void should_return_ticket_when_car_is_park_given_parked_car() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        //when
        ParkingTicket ticket = parkingBoy.park(car);
        //then
        assertNotNull(ticket);
    }


    @Test
    public void should_fetch_right_car_when_parking_boy_fetch_given_parking_ticket(){
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
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
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
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
            ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
            ParkingTicket parkingTicket = parkingBoy.park(car);
            ParkingTicket wrongTicket = new ParkingTicket();

            //when
            Car fetchedCar = parkingBoy.fetch(wrongTicket);
            //then
            assertSame(null, fetchedCar);
        }
}

    

