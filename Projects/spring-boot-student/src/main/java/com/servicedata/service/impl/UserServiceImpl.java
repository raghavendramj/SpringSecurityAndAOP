package com.servicedata.service.impl;


import com.servicedata.entity.User;
import com.servicedata.repository.UserRepository;
import com.servicedata.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserDetailsService {


    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        User databaseUser = userRepository.findByUsername(username);

        if(databaseUser == null){
            throw new UsernameNotFoundException("Cannot find the user");
        }

        return new CustomUserDetails(databaseUser);

        //Logic to get the username from database.
        //return new User("admin", "password", new ArrayList<>());
    }
}
