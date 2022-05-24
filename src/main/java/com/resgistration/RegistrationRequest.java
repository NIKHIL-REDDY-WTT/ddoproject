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
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final String mobileNumber;
    private final String designation;

    //    public ResgistrationsRequest(String firstname, String lastname, String email, String password) {
    //        this.firstname = firstname;
    //        Lastname = lastname;
    //        this.email = email;
    //        Password = password;
    //    }
}
