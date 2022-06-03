package com.project.amore.model.service.impl;

import com.project.amore.model.entity.Usuario;
import com.project.amore.model.repository.UserRepository;
import com.project.amore.model.service.UserService;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<Usuario> getUsers() {
    List<Usuario> usuarios = new ArrayList<>();
    userRepository.findAll().forEach(usuarios::add);
    return usuarios;
  }

  @Override
  public Usuario saveUser() {
    return null;
  }

  @Override
  public Usuario findUserByUsername(String username) {
    Usuario usuario = userRepository.findByUsername(username);
    return usuario;
  }
}
