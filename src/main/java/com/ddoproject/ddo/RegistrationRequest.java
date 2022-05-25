package com.ddoproject.ddo;

import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
@Data
public class RegistrationRequest {
    private  String userName;
    private  String email;
    private  String password;
}
