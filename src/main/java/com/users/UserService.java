package com.users;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

    @Service
    @AllArgsConstructor
<<<<<<< Updated upstream
    public class UserService implements UserDetailsService {
        private UserRepository usersRepository;
=======
    public class UsersService implements UserDetailsService {
        private final static String  USER_NOT_FOUND_NSG="User not found";
        private final  UserRepository usersRepository;
>>>>>>> Stashed changes
        @Override
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            return (UserDetails) usersRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("user name not found"));
        }
    }

