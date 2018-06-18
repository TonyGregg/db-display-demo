package com.genil.hibernate.dbdisplaydemo.controllers;

import com.genil.hibernate.dbdisplaydemo.domain.User;
import com.genil.hibernate.dbdisplaydemo.repos.UserQueryByExample;
import com.genil.hibernate.dbdisplaydemo.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by genil on 6/17/18 at 09 26
 **/

@RestController
@RequestMapping(path = "/users")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired private UserRepository userRepository;


    @PostMapping(path = "/all")
    public @ResponseBody
    List<User> getAllUsers() {
        int size = 5;
        int page = 0; //zero-based page index.
        Pageable pageable = PageRequest.of(page, size);
        Page<User> usersPage = userRepository.findAll(pageable);
        logger.info("Total elements "+usersPage.getTotalElements() + " Total pages "+usersPage.getTotalPages() + " has next "+usersPage.hasNext());

        return userRepository.findAll();
    }

    @PostMapping(value = "/getUserByLastName")
    public Iterable<User>getUserByLastName(@RequestBody User user) {
        logger.info("Inside the controller. Last name passed "+user.getLastName());


        return userRepository.findByLastName(user.getLastName());
    }

}
