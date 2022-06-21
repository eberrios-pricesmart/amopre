package com.project.amore.model.service.impl;

import com.project.amore.model.entity.Role;
import com.project.amore.model.entity.Usuario;
import com.project.amore.model.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  @Transactional(readOnly=true)
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Usuario usuario = userRepository.findByUsername(username);

    if(usuario == null) {
      throw new UsernameNotFoundException("Username: " + username + " no existe en el sistema!");
    }

    List<GrantedAuthority> authorities = new ArrayList<>();

    authorities.add(new SimpleGrantedAuthority(usuario.getRoles().getAuthority()));

    return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
  }
}
