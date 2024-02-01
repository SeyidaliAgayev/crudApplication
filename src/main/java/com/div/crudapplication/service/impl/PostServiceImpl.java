package com.div.crudapplication.service.impl;

import com.div.crudapplication.model.PostEntity;
import com.div.crudapplication.model.UserEntity;
import com.div.crudapplication.repositories.PostRepository;
import com.div.crudapplication.service.PostServiceInter;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PostServiceImpl implements PostServiceInter {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public void createPost(PostEntity postEntity) {
        postEntity.setDescription("");
        postEntity.setUserEntity(UserEntity.builder().build());
        postEntity.setCreateDate(new Date());
        postEntity.setEditDate(new Date());

        postRepository.save(postEntity);
    }

    @Override
    public List<PostEntity> getPost() {
        List<PostEntity> allPosts = postRepository.findAll();
        return allPosts;
    }

    @Override
    public void deletePost(Long postId) {
        Optional<PostEntity> optionalPost = postRepository.findById(postId);

        if (optionalPost.isPresent()) {
            postRepository.delete(optionalPost.get());
        } else {
        }
    }

    @Override
    public void updatePost(PostEntity postEntity) {

        Optional<PostEntity> existingPostOptional = postRepository.findById(postEntity.getId());

        if (existingPostOptional.isPresent()) {
            PostEntity existingPost = existingPostOptional.get();
            existingPost.setUserEntity(UserEntity.builder().build());
            existingPost.setDescription(postEntity.getDescription());
            existingPost.setEditDate(new Date());
            existingPost.setCreateDate(new Date());

            postRepository.save(existingPost);
        } else {
        }

    }
}
