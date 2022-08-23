package com.api.parkingcontrol.exceptions;

public class DuplicateParkingSpotByApartmentAndBlockException extends RuntimeException {
    public DuplicateParkingSpotByApartmentAndBlockException () { super("Conflict: Parking Spot is already registered"); }
}
