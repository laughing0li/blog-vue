package com.banjo.blogvue.dao;

import com.banjo.blogvue.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {

    User findByUsernameAndPassword(String username, String password);
}
