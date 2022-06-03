package com.project.amore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotFoundController {

  @GetMapping("/notFound")
  public String index(Model mv){
    return "404";
  }
}
