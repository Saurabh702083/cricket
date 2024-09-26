package com.sports.cricket.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

import lombok.Data;
import lombok.Generated;
@Data
@Entity
@Table(name = "coach_table")
public class Coach {
    @Id
    private String coachId;
    private String name;
    private String gender;
    private LocalDate dateOfBirth;
    private String password;
    private Long mobileNumber;
    private String speciality;
    private int noOfBooking;
    private Double fees;
    private Double amount;

}






