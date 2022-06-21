package com.project.amore.model.service.impl;

import com.project.amore.model.dto.CarrouselDTO;
import com.project.amore.model.entity.Blog;
import com.project.amore.model.entity.Carrousel;
import com.project.amore.model.repository.BlogRepository;
import com.project.amore.model.repository.CarrouselRepository;
import com.project.amore.model.service.IndexService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexServiceImpl implements IndexService {

  @Autowired
  private CarrouselRepository carrouselRepository;

  @Autowired
  private BlogRepository blogRepository;

  @Override
  public List<CarrouselDTO> getDataCarrousel() {
    List<CarrouselDTO> carrouselList = new ArrayList<>();
    carrouselRepository.findAll().forEach(carrousel -> {
      carrouselList.add(mapCarrouselToDto(carrousel));
    });
    if(!carrouselList.isEmpty()){
      carrouselList.get(0).setActive(true);
    }
    return carrouselList;
  }

  @Override
  public List<Blog> getBlogs() {
    List<Blog> blogList = new ArrayList<>();
    blogRepository.findAll().forEach(blogList::add);
    return blogList;
  }

  private CarrouselDTO mapCarrouselToDto(Carrousel carrousel){
    CarrouselDTO carrouselDTO = new CarrouselDTO();
    carrouselDTO.setId(carrousel.getId());
    carrouselDTO.setTitle(carrousel.getTitle());
    carrouselDTO.setDescription(carrousel.getDescription());
    carrouselDTO.setButtonName(carrousel.getButtonName());
    return carrouselDTO;
  }
}
