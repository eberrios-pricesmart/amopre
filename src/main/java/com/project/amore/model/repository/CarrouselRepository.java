package com.project.amore.model.repository;

import com.project.amore.model.entity.Carrousel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrouselRepository extends CrudRepository<Carrousel,Long> {

}
