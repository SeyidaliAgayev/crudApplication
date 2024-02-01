package com.div.crudapplication.service;

import com.div.crudapplication.model.UserEntity;

import java.util.List;

public interface UserServiceInter {
    void createUser(UserEntity userEntity);
    List<UserEntity> getUser();
    void deleteUser(Long userId);
    void updateUser(UserEntity updatedUser);
}
