package com.api.parkingcontrol.handlers;

import com.api.parkingcontrol.controllers.ParkingSpotController;
import com.api.parkingcontrol.exceptions.DuplicateLicensePlateCarException;
import com.api.parkingcontrol.exceptions.DuplicateParkingSpotByApartmentAndBlockException;
import com.api.parkingcontrol.exceptions.DuplicateParkingSpotNumberEception;
import com.api.parkingcontrol.exceptions.ParkingSpotNotFoundExecption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;

@ControllerAdvice(basePackageClasses = ParkingSpotController.class)
public class ParkingSpotHandler extends ResponseEntityExceptionHandler {
    private LinkedHashMap<Object, Object> _fillErrorMessages(String message) {
        LinkedHashMap<Object, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", message);
        return body;
    }

    @ExceptionHandler(DuplicateLicensePlateCarException.class)
    public ResponseEntity<Object> handleDuplicateLicensePlateCarException (DuplicateLicensePlateCarException execption) {
        LinkedHashMap<Object, Object> body = _fillErrorMessages(execption.getMessage());
        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(DuplicateParkingSpotNumberEception.class)
    public ResponseEntity<Object> handleDuplicateParkingSpotNumberEception (DuplicateParkingSpotNumberEception execption) {
        LinkedHashMap<Object, Object> body = _fillErrorMessages(execption.getMessage());
        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(DuplicateParkingSpotByApartmentAndBlockException.class)
    public ResponseEntity<Object> handleDuplicateParkingSpotByApartmentAndBlockException (DuplicateParkingSpotByApartmentAndBlockException execption) {
        LinkedHashMap<Object, Object> body = _fillErrorMessages(execption.getMessage());
        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ParkingSpotNotFoundExecption.class)
    public ResponseEntity<Object> handleParkingSpotNotFoundExecption (ParkingSpotNotFoundExecption execption) {
        LinkedHashMap<Object, Object> body = _fillErrorMessages(execption.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
