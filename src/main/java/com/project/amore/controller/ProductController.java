package com.project.amore.controller;

import com.project.amore.model.dto.ActiveSideBarDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

  private ActiveSideBarDTO activeSideBarDTO = new ActiveSideBarDTO();

  @GetMapping("/products")
  public String productPage(Model model){
    activeSideBarDTO.setProducts(true);
    model.addAttribute("active", activeSideBarDTO);
    return "interfaces/product";
  }
}
