package com.project.amore.controller;

import com.project.amore.model.service.UserService;
import java.io.IOException;
import java.security.Principal;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

  @GetMapping("/login")
  public String login(@RequestParam(value = "error", required = false) String error,
      @RequestParam(value = "logout", required = false) String logout,
      Model model, Principal principal, RedirectAttributes flash) {

    if (principal != null) {
      flash.addFlashAttribute("info", "Ya ha inciado sesión anteriormente");
      return "redirect:/";
    }

    if (error != null) {
      model.addAttribute("error", "Email o Contraseña incorrectos.");
    }

    if (logout != null) {
      model.addAttribute("success", "Ha cerrado sesión con éxito!");
    }

    return "login";
  }

  @RequestMapping("/success")
  public void loginPageRedirect(HttpServletRequest request, HttpServletResponse response,
      Authentication authResult) throws IOException, ServletException {

    String role = authResult.getAuthorities().toString();

    if (role.contains("ROLE_ADMIN")) {
      response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/products"));
    } else if (role.contains("ROLE_USER")) {
      response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/index"));
    }
  }
}
