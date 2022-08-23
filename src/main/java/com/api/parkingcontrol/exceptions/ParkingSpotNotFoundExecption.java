package com.api.parkingcontrol.exceptions;

public class ParkingSpotNotFoundExecption extends RuntimeException {
    public ParkingSpotNotFoundExecption () { super("Parking spot not found"); }
}
