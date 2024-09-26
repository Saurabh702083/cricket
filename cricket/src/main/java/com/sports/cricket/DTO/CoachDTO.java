package com.sports.cricket.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

import lombok.Data;
import lombok.Generated;
@Data
public class CoachDTO {
    private @NotEmpty @Size(
            min = 3,
            max = 15,
            message = "name is not valid"
    ) String name;
    private String gender;
    private LocalDate dateOfBirth;
    private @NotEmpty @Size(
            min = 5,
            max = 50,
            message = "{name.validation.empty}"
    ) String speciality;
    private @NotEmpty @Size(
            min = 5,
            max = 10,
            message = "password is not valid"
    ) String password;
    private @Min(
            value = 9L,
            message = "{name.validation.empty}"
    ) Long mobileNumber;
    private Double fees;


}
