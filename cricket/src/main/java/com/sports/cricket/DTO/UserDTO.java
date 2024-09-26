package com.sports.cricket.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

import lombok.Data;

@Data
public class UserDTO {
    private @NotEmpty @Size(
            min = 3,
            max = 50,
            message = "{name1.validation.length}"
    ) String name;
    private String gender;
    private LocalDate dateOfBirth;
    private @Email(
            message = "email is not valid"
    ) String email;
    private @NotEmpty @Size(
            min = 3,
            max = 15,
            message = "password is not valid"
    ) String password;
    private @Min(
            value = 999999999L,
            message = "Mobile number is not valid"
    ) @Max(
            value = 1000000000L,
            message = "Mobile number is not valid"
    ) Long mobileNumber;
    private @Min(
            value = 99999L,
            message = "PIN code should be valid"
    ) @Max(
            value = 1000000L,
            message = "PIN code should be valid"
    ) int pincode;
    private @NotEmpty @Size(
            min = 3,
            max = 30,
            message = "city is is not valid"
    ) String city;
    private @NotEmpty @Size(
            min = 3,
            max = 30,
            message = "State is not valid"
    ) String state;
    private @NotEmpty @Size(
            min = 3,
            max = 30,
            message = "country is not valid"
    ) String country;


}
