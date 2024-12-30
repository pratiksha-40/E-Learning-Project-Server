package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.ContactOfQuery;
import com.example.demo.Repository.ContactUsQueryRepository;

@Service
public class ContactOfQueryService {

    @Autowired
    private ContactUsQueryRepository repository;

    @Autowired
    private JavaMailSender mailSender;

    public ContactOfQuery saveQuery(ContactOfQuery query) {
        // Save the query to the database
        ContactOfQuery savedQuery = repository.save(query);

        // Send email to admin
        sendEmailToAdmin(savedQuery);

        return savedQuery;
    }

    private void sendEmailToAdmin(ContactOfQuery query) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("mailosud123@gmail.com"); // Replace with the actual admin email
        message.setSubject("New Contact Us Query");
        message.setText("A new query has been submitted:\n\n" +
                "Name: " + query.getFullName() + "\n" +
                "Email: " + query.getEmail() + "\n" +
                "Message: " + query.getMessage());
        mailSender.send(message);
    }
}