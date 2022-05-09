package com.project.amore.controller;

import com.project.amore.entity.Carrousel;
import com.project.amore.service.IndexService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/index")
public class IndexController {

  @Autowired
  private IndexService indexService;

  @GetMapping("/home")
  public String index(Model mv){
    List<Carrousel> carrouselList = indexService.getDataCarrousel();
    mv.addAttribute("listCarrousel", carrouselList);
    return "index";
  }

  @GetMapping("/login")
  public String login(){
    return "login";
  }

}
