package com.project.amore.controller;

import com.project.amore.entity.User;
import com.project.amore.service.UserService;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

  @Autowired
  private UserService userService;

  @PostMapping("/login")
  public String hasAccount(@ModelAttribute(name = "loginForm") User user, Model m) {
    User responseUser = userService.findUserByUsername(user.getUsername());
    if (Objects.nonNull(responseUser)) {
      if (responseUser.getUsername().equals(user.getUsername()) && responseUser.getPassword()
          .equals(user.getPassword())) {
        m.addAttribute("uname", responseUser.getUsername());
        return "dashboard";
      }
    }
    m.addAttribute("error", "Incorrect Username & Password");
    return "login";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }
}
