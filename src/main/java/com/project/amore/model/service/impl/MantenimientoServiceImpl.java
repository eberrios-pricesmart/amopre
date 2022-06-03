package com.project.amore.model.service.impl;

import com.project.amore.model.dto.CarrouselDTO;
import com.project.amore.model.entity.Blog;
import com.project.amore.model.entity.Carrousel;
import com.project.amore.model.repository.BlogRepository;
import com.project.amore.model.repository.CarrouselRepository;
import com.project.amore.model.repository.UserRepository;
import com.project.amore.model.service.MantenimientoService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MantenimientoServiceImpl implements MantenimientoService {

  @Autowired
  private CarrouselRepository carrouselRepository;

  @Autowired
  private BlogRepository blogRepository;

  @Autowired
  private UserRepository userRepository;

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
  public Carrousel getCarrouselById(Long id) {
    Optional<Carrousel> carrousel = carrouselRepository.findById(id);
    if( carrousel.isPresent()){
      return carrousel.get();
    } else{
      return new Carrousel();
    }
  }

  @Override
  public void saveCarrousel(Carrousel carrousel) {
    carrousel.setUsuario(userRepository.findById(1L).get());
    carrouselRepository.save(carrousel);
  }

  @Override
  public void deleteCarrousel(Long id) {
    carrouselRepository.deleteById(id);
  }

  @Override
  public List<Blog> getBlogs() {
    List<Blog> blogList = new ArrayList<>();
    blogRepository.findAll().forEach(blogList::add);
    return blogList;
  }

  @Override
  public Blog getBlogById(Long id) {
    Optional<Blog> blog = blogRepository.findById(id);
    if (blog.isPresent()){
      return blog.get();
    } else {
      return new Blog();
    }
  }

  @Override
  public void saveBlog(Blog blog) {
    blog.setUsuario(userRepository.findById(1L).get());
    blogRepository.save(blog);
  }

  @Override
  public void deleteBlog(Long id) {
    blogRepository.deleteById(id);
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
