package com.div.crudapplication.repositories;

import com.div.crudapplication.model.PostEntity;
import com.div.crudapplication.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
