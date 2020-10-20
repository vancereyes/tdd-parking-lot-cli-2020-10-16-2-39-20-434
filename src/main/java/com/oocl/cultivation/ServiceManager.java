package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ServiceManager extends ParkingBoy{
    private List<ParkingBoy> managementList;

    public ServiceManager(List<ParkingLot> parkingLotArrayList) {
        super(parkingLotArrayList);
    }

    public void addToList(ParkingBoy parkingBoy) {
    }

    public List<ParkingBoy> getManagementList() {
        return managementList;
    }
}
