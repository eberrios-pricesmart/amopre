package com.project.amore.repository;

import com.project.amore.entity.Carrousel;
import com.project.amore.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

}
