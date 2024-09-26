package com.sports.cricket.Entities;

//package com.WeCare.WeCare.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

import lombok.Data;
import lombok.Generated;

@Entity
@Data
@Table(name = "UserTable")
public class User {
    @Id
    private String userId;
    private String name;
    private String gender;
    private LocalDate dateOfBirth;
    private String password;
    private Long mobileNumber;
    private String email;
    private Integer pincode;
    private String city;
    private String state;
    private String country;

}

