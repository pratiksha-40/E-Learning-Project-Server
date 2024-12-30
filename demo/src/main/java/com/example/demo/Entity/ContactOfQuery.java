package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contact_of_query")
@Getter
@Setter
@NoArgsConstructor
public class ContactOfQuery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private String message;

    // Optional Constructor for easier instantiation
    public ContactOfQuery(String fullName, String email, String message) {
        this.fullName = fullName;
        this.email = email;
        this.message = message;
    }
}
