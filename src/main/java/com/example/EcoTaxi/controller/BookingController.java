package com.example.EcoTaxi.controller;

import com.example.EcoTaxi.entity.Booking;
import com.example.EcoTaxi.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings/")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/request")
    public ResponseEntity<?> createBooking(@RequestBody Booking bookingRequest) {

        if (bookingRequest.getClientName() == null ||
                bookingRequest.getPhoneNumber() == null ||
                bookingRequest.getPickupLocation() == null ||
                bookingRequest.getDestinationLocation() == null) {

            return ResponseEntity.badRequest().body("Invalid request");
        }

        Booking createdBooking = bookingService.processNewBookingRequest(bookingRequest);
        return ResponseEntity.ok(createdBooking);

    }


}
