package com.teksystems.capstone.database.entrybeans;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class UserEntryBean {

    private Integer id;

    private String email;

    private String firstName;

    private String lastName;

    private String password;

    private String confirmPassword;

    private String dateOfBirth;

    private String addressOne;

    private String addressTwo;

    private String aptNumber;

    private String state;

    private Integer zipCode;


}
