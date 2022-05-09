package com.project.amore.repository;

import com.project.amore.entity.Carrousel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrouselRepository extends CrudRepository<Carrousel,Long> {

}
