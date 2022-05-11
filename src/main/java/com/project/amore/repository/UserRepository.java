package com.project.amore.repository;

import com.project.amore.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

  @Query(value = "SELECT * FROM user_accounts U WHERE U.username =:user_name" , nativeQuery = true)
  User findByUsername(@Param("user_name") String username);
}
