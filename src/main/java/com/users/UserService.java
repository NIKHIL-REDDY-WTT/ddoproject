package com.users;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.resgistration.Security.ConfirmationToken;
import com.resgistration.Security.ConfirmationTokenService;

@Service
    @AllArgsConstructor

    public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =  "user with email %s not found";
        private final UserRepository userRepository;
        private final BCryptPasswordEncoder bCryptPasswordEncoder;
        private final ConfirmationTokenService confirmationTokenService;

        @Override
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findByEmail(email).orElseThrow(() ->
                                        new UsernameNotFoundException(
                                                String.format(USER_NOT_FOUND_MSG, email)));
    }
    public String signUpUser(User appUser) {
        boolean userExists = userRepository
                .findByEmail(appUser.getEmail())
                .isPresent();

        if (userExists) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.

            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);

        userRepository.save(appUser);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);

        //        TODO: SEND EMAIL

        return token;
    }

    public Optional<Object> enableAppUser(String email) {
        return userRepository.findByEmail(email);
    }
}


