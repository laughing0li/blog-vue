package com.banjo.blogvue.service;


import com.banjo.blogvue.dao.UserDAO;
import com.banjo.blogvue.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public User getOne(int id) {
        return userDAO.getOne(id);
    }

    public User checkUser(String username, String password) {
        return userDAO.findByUsernameAndPassword(username, password);
    }
}
