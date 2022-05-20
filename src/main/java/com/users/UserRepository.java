package com.users;

import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Transactional
public interface UserRepository {
    Optional<Object> findByEmail(String email);
}
