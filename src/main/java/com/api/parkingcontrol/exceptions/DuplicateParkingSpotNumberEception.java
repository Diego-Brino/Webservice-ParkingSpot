package com.api.parkingcontrol.exceptions;

public class DuplicateParkingSpotNumberEception extends RuntimeException {
    public DuplicateParkingSpotNumberEception () { super("Conflict: Parking Spot Number is already in use!"); }
}
