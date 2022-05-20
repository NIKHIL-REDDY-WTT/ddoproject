package com.users;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

public class UserService {

    @Service
    @AllArgsConstructor
    public class UsersService implements UserDetailsService {
        private UserRepository usersRepository;
        @Override
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            return (UserDetails) usersRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("user name not found"));
        }
    }
}
