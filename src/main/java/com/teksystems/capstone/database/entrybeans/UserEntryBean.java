package com.teksystems.capstone.database.entrybeans;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@ToString
public class UserEntryBean {


    private Integer id;


    @Email(message = "Email is required")
    private String email;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "First name is required")
    private String lastName;

    @Length(min = 3, max = 15, message = "Password must be between 3 and 15 characters")
    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Confirm Password is required")
    private String confirmPassword;

    private String dateOfBirth;

    private String addressOne;

    private String addressTwo;

    private String aptNumber;

    private String state;

    private Integer zipCode;

}
