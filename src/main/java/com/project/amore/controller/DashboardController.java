package com.project.amore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

  @GetMapping(value = "dashboard")
  public ModelMap mmDashboard() {
    return new ModelMap();
  }
}
