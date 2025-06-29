package com.example.EcoTaxi.service;

import com.example.EcoTaxi.entity.Booking;
import jakarta.persistence.Id;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {


    private JavaMailSender mailSender;

    public void sendBookingNotificationEmail(Booking booking) {
        SimpleMailMessage message = new SimpleMailMessage();

        String recipientEmail = "mecimarisa@gmail.com";
        String subject = "Kërkesë e re për Taksi - ID: " + booking.getId();

        String emailBody = "Përshëndetje stafi i EcoTaxi,\n\n"
                + "Një kërkesë e re për rezervim taksie sapo është regjistruar. Më poshtë gjeni detajet:\n\n"
                + "========================================\n"
                + "ID e Kërkesës: " + booking.getId() + "\n"
                + "Emri i Klientit: " + booking.getClientName() + "\n"
                + "Numri i Telefonit: " + booking.getPhoneNumber() + "\n\n"
                + "Lokacioni: " + booking.getPickupLocation() + "\n"
                + "Destinacioni: " + booking.getDestinationLocation() + "\n\n"
                + "Koha e kërkesës: " + booking.getRequestTime().toString() + "\n"
                + "========================================\n\n"
                + "Ju lutem kontaktoni klientin për të konfirmuar dhe caktuar shërbimin.\n\n"
                + "Faleminderit ";

        message.setTo(recipientEmail);
        message.setSubject(subject);
        message.setText(emailBody);


        mailSender.send(message);
    }


    }

