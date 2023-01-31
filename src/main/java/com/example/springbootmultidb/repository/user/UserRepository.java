package com.example.springbootmultidb.repository.user;

import com.example.springbootmultidb.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User,Integer> {
}
