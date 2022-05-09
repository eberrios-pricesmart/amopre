package com.project.amore.service.impl;

import com.project.amore.entity.Carrousel;
import com.project.amore.repository.CarrouselRepository;
import com.project.amore.service.IndexService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexServiceImpl implements IndexService {

  @Autowired
  private CarrouselRepository carrouselRepository;

  @Override
  public List<Carrousel> getDataCarrousel() {
    List<Carrousel> carrouselList = new ArrayList<>();
    carrouselRepository.findAll().forEach(carrouselList::add);
    return carrouselList;
  }
}
