package com.resgistration;

import org.springframework.stereotype.Service;
import com.users.UserService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistrationService {
  private final UserService userService;




    String register(RegistrationRequest request) {
        return "it works";

    }
}
