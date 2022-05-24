package com.resgistration;

import org.springframework.stereotype.Service;
import com.Security.ConfirmationTokenService;
import com.email.EmailSender;
import com.email.EmailValidator;
import com.users.UserService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistrationService {
  private final UserService userService;
    private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailSender emailSender;}
