package com.sports.cricket.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

import lombok.Data;
import lombok.Generated;

@Entity
@Data
@Table(name = "bookingTable")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookingId;
    private String userId;
    private String coachId;
    private LocalDate appointmentDate;
    private String slot;
}
