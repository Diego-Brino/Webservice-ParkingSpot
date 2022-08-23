package com.api.parkingcontrol.exceptions;

public class DuplicateLicensePlateCarException extends RuntimeException {
    public DuplicateLicensePlateCarException () { super("Conflict: License Plate Car is already in use!"); }
}
