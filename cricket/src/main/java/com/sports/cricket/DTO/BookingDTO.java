package com.sports.cricket.DTO;

import java.time.LocalDate;

import lombok.Data;
import lombok.Generated;

@Data
public class BookingDTO {
    private String userId;
    private String coachId;
    private LocalDate appointmentDate;
    private String slot;

}
