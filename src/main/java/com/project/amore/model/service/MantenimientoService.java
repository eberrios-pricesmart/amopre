package com.project.amore.model.service;

import com.project.amore.model.dto.CarrouselDTO;
import com.project.amore.model.entity.Blog;
import com.project.amore.model.entity.Carrousel;
import java.util.List;

public interface MantenimientoService {

  List<CarrouselDTO> getDataCarrousel();

  Carrousel getCarrouselById(Long id);

  void saveCarrousel(Carrousel carrousel);

  void deleteCarrousel(Long id);

  List<Blog> getBlogs();

  Blog getBlogById(Long id);

  void saveBlog(Blog blog);

  void deleteBlog(Long id);


}
