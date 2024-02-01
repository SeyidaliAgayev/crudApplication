package com.div.crudapplication.service;

import com.div.crudapplication.model.PostEntity;
import com.div.crudapplication.model.UserEntity;

import java.util.List;

public interface PostServiceInter {
    void createPost(PostEntity postEntity);
    List<PostEntity> getPost();
    void deletePost(Long postId);
    void updatePost(PostEntity postEntity);
}
