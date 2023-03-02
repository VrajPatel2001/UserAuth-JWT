package com.onethread.cms.service;

import com.onethread.cms.model.User;
import com.onethread.cms.model.UserDto;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    User save(UserDto user);
    List<User> findAll();
    User findOne(String username);

    UserDetails loadUserByUsername(String username);
}
