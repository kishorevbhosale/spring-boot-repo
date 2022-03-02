package com.kb.springbootschedular.repository;

import com.kb.springbootschedular.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
