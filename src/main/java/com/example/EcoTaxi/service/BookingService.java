package com.example.EcoTaxi.service;

import com.example.EcoTaxi.entity.Booking;
import com.example.EcoTaxi.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private EmailService emailService;

    public Booking processNewBookingRequest(Booking bookingRequest) {

        bookingRequest.setRequestTime(LocalDateTime.now());


        Booking savedBooking = bookingRepository.save(bookingRequest);

        try {

            emailService.sendBookingNotificationEmail(savedBooking);

        }catch (Exception e){
            System.err.println("Error sending booking notification email with ID: " +
                     savedBooking.getId());
            e.printStackTrace();
        }

        return savedBooking;

    }

}
