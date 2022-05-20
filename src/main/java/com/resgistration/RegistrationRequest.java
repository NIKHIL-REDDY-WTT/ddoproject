package com.resgistration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String firstname;
    private final String Lastname;
    private final String email;
    private final String Password;
    private final String Mobilenumber;
    private final String Designation;

    //    public ResgistrationsRequest(String firstname, String lastname, String email, String password) {
    //        this.firstname = firstname;
    //        Lastname = lastname;
    //        this.email = email;
    //        Password = password;
    //    }
}
