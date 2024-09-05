package com.vikas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vikas.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
