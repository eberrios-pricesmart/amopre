package com.project.amore.model.service;

import com.project.amore.model.dto.CarrouselDTO;
import com.project.amore.model.entity.Blog;
import com.project.amore.model.entity.Carrousel;
import java.util.List;

public interface IndexService {

  List<CarrouselDTO> getDataCarrousel();

  List<Blog> getBlogs();
}
