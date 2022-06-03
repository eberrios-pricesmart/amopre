package com.project.amore.controller;

import com.project.amore.model.entity.Carrousel;
import com.project.amore.model.service.IndexService;
import java.net.MalformedURLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

  @Autowired
  private IndexService indexService;

  @GetMapping("/index")
  public String index(Model mv){
    mv.addAttribute("listCarrousel", indexService.getDataCarrousel());
    mv.addAttribute("listBlogs", indexService.getBlogs());
    return "index";
  }

}
