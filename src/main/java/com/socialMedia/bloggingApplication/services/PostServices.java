package com.socialMedia.bloggingApplication.services;

import com.socialMedia.bloggingApplication.entities.Posts;
import com.socialMedia.bloggingApplication.entities.Users;
import com.socialMedia.bloggingApplication.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServices {

    @Autowired
    private PostsRepository postsRepository;
    public String addPost(Posts post) {
        Posts getPost = postsRepository.save(post);
        if(getPost.equals(post)) {
            return "post added successfully";

        }
        else {
            return "There is some issue";
        }
    }

    public List<Posts> findAll() {
        return postsRepository.findAll();
    }

    public void deleteById(String id) {
        postsRepository.deleteById(id);
    }

    public Optional<Posts> findPostById(String id) {
        return postsRepository.findById(id);
    }

    public String updatePost(Posts post , String id) {
        Optional<Posts> getPost = postsRepository.findById(id);
        if(getPost.isPresent()){
            postsRepository.save(post);
            return "Post updated successsfullly";
        }
        else {
            return "post not find";
        }

    }
}
