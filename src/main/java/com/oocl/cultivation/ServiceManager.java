package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ServiceManager extends ParkingBoy{
    private List<ParkingBoy> managementList;

    public ServiceManager(List<ParkingLot> parkingLotArrayList) {
        super(parkingLotArrayList);
        managementList = new ArrayList<>();
    }

    public void addToList(ParkingBoy parkingBoy) {
        managementList.add(parkingBoy);
    }

    public List<ParkingBoy> getManagementList() {
        return managementList;
    }

    public void addToManagementList(ParkingBoy parkingBoy) {

    }

    public ParkingTicket assignToParkCar(ParkingBoy parkingBoy, Car car) {
        return null;
    }
}
