package com.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Transactional
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<Object> findByEmail(String email);
}
