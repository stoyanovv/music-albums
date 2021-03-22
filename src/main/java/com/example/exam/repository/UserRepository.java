package com.example.exam.repository;

import com.example.exam.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String > {

    Optional<User> findByUsernameAndPassword(String username, String password);

    User getById(String id);

    User findByUsername(String username);
}