package com.project.amore.controller;

import com.project.amore.model.dto.ActiveSideBarDTO;
import com.project.amore.model.entity.Blog;
import com.project.amore.model.entity.Carrousel;
import com.project.amore.model.service.MantenimientoService;
import com.project.amore.model.service.UploadFileService;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MantenimientoController {

  @Autowired
  private MantenimientoService mantenimientoService;
  @Autowired
  private UploadFileService uploadFileService;
  private ActiveSideBarDTO activeSideBarDTO = new ActiveSideBarDTO();

  public MantenimientoController() {
    activeSideBarDTO.setMantenimiento(true);
  }

  @GetMapping("/carrousel")
  public String formCarrousel(Model model){
    model.addAttribute("active", activeSideBarDTO);
    model.addAttribute("specificCarrousel",new Carrousel());
    return "interfaces/formularios/carrousel";
  }

  @GetMapping("/carrousel/{id}")
  public String formCarrousel(Model model, @PathVariable(value="id")Long id){
    model.addAttribute("active", activeSideBarDTO);
    model.addAttribute("specificCarrousel",mantenimientoService.getCarrouselById(id));
    return "interfaces/formularios/carrousel";
  }

  @GetMapping("/eliminar/carrousel/{id}")
  public String deleteCarrousel(@PathVariable(value="id")Long id){
    mantenimientoService.deleteCarrousel(id);
    return "redirect:/mnt_portada";
  }


  @PostMapping("/carrousel")
  public String saveCarrousel(@ModelAttribute(name = "carrouselNew") Carrousel carrousel){
    mantenimientoService.saveCarrousel(carrousel);
    return "redirect:/mnt_portada";
  }

  @GetMapping("/mnt_portada")
  public String mantenimientoPortada(Model model){
    model.addAttribute("carrouselList", mantenimientoService.getDataCarrousel());
    model.addAttribute("active", activeSideBarDTO);
    model.addAttribute("title", "Portada");
    return "interfaces/mnt_portada";
  }

  //INICIO BLOG

  @GetMapping("/mnt_blog")
  public String mantenimientoBlog(Model model){
    model.addAttribute("active", activeSideBarDTO);
    model.addAttribute("blogList", mantenimientoService.getBlogs());
    model.addAttribute("title", "Blogs");
    return "interfaces/mnt_blog";
  }

  @GetMapping("/blog_form")
  public String formBlog(Model model){
    model.addAttribute("active", activeSideBarDTO);
    model.addAttribute("specificBlog",new Blog());
    return "interfaces/formularios/blog_form";
  }

  @GetMapping("/blog_form/{id}")
  public String formBlog(Model model, @PathVariable(value="id")Long id){
    model.addAttribute("active", activeSideBarDTO);
    model.addAttribute("specificBlog",mantenimientoService.getBlogById(id));
    return "interfaces/formularios/blog_form";
  }

  @GetMapping("/eliminar/blog/{id}")
  public String deleteBlog(@PathVariable(value="id")Long id){
    mantenimientoService.deleteBlog(id);
    return "redirect:/mnt_blog";
  }

  @PostMapping("/blog")
  public String saveBlog(@ModelAttribute(name = "blogNew") Blog blog, @RequestParam("file") MultipartFile foto, SessionStatus status){

    if (!foto.isEmpty()) {

      if (blog.getId() != null && blog.getId() > 0 && blog.getImage() != null
          && blog.getImage().length() > 0) {

        uploadFileService.delete(blog.getImage());
      }

      String uniqueFilename = null;
      try {
        uniqueFilename = uploadFileService.copy(foto);
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      blog.setImage(uniqueFilename);
      mantenimientoService.saveBlog(blog);
      status.setComplete();
    }
    return "redirect:/mnt_blog";
  }

  @GetMapping(value = "/uploads/{filename:.+}")
  public ResponseEntity<Resource> verFoto(@PathVariable String filename) {

    Resource recurso = null;

    try {
      recurso = uploadFileService.load(filename);
    } catch (MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"")
        .body(recurso);
  }

  //FIN BLOG

}
