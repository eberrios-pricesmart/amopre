package com.project.amore.service.impl;

import com.project.amore.entity.User;
import com.project.amore.repository.UserRepository;
import com.project.amore.service.UserService;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<User> getUsers() {
    List<User> users = new ArrayList<>();
    userRepository.findAll().forEach(users::add);
    return users;
  }

  @Override
  public User saveUser() {
    return null;
  }

  @Override
  public User findUserByUsername(String username) {
    User user = userRepository.findByUsername(username);
    return user;
  }
}
