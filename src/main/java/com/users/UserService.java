package com.users;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

    @Service
    @AllArgsConstructor

    public class UserService implements UserDetailsService {
        private final static String USER_NOT_FOUND_NSG = "User not found";
        private final UserRepository userRepository;

        @Override
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            return (UserDetails) userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("user name not found"));
        }
    }

