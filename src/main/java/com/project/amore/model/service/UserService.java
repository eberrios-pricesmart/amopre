package com.project.amore.model.service;

import com.project.amore.model.entity.Usuario;
import java.util.List;

public interface UserService {

  List<Usuario> getUsers();

  Usuario saveUser();

  Usuario findUserByUsername(String username);

}
