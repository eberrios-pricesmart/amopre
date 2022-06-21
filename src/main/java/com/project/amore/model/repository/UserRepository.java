package com.project.amore.model.repository;

import com.project.amore.model.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Usuario,Long> {

  Usuario findByUsername(String username);
}
