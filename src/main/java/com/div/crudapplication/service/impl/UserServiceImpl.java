package com.div.crudapplication.service.impl;

import com.div.crudapplication.model.UserEntity;
import com.div.crudapplication.repositories.UserRepository;
import com.div.crudapplication.service.UserServiceInter;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class UserServiceImpl implements UserServiceInter {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void createUser(UserEntity userEntity) {
        userEntity.setName("");
        userEntity.setEmail("");
        userEntity.setSurname("");
        userEntity.setPhoneNumber("");
        userEntity.setCreateDate(new Date());
        userEntity.setBirthdate(new Date());
        userEntity.setUpdateDate(new Date());

        userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> getUser() {
        List<UserEntity> allUsers = userRepository.findAll();
        return allUsers;
    }

    @Override
    public void deleteUser(Long userId) {
        Optional<UserEntity> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            userRepository.delete(optionalUser.get());
        } else {
        }
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        Optional<UserEntity> existingUserOptional = userRepository.findById(userEntity.getId());

        if (existingUserOptional.isPresent()) {
            UserEntity existingUser = existingUserOptional.get();
            existingUser.setName(userEntity.getName());
            existingUser.setSurname(userEntity.getSurname());
            existingUser.setEmail(userEntity.getEmail());
            existingUser.setPhoneNumber(userEntity.getPhoneNumber());
            existingUser.setBirthdate(userEntity.getBirthdate());
            existingUser.setUpdateDate(new Date());

            userRepository.save(existingUser);
        } else {
        }

    }
}
