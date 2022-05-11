package com.project.amore.service;

import com.project.amore.entity.User;
import java.util.List;

public interface UserService {

  List<User> getUsers();

  User saveUser();

  User findUserByUsername(String username);

}
