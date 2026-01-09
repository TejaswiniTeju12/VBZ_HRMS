package com.vbz.hrms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vbz.hrms.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

    boolean existsByUsername(String username);

    Optional<Users> findByUsernameAndPassword(String username, String password);
}
