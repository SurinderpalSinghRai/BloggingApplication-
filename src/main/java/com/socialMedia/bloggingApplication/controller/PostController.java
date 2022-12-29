package com.socialMedia.bloggingApplication.controller;

import com.socialMedia.bloggingApplication.entities.Posts;
import com.socialMedia.bloggingApplication.entities.Users;
import com.socialMedia.bloggingApplication.repository.UsersRepository;
import com.socialMedia.bloggingApplication.services.PostServices;
import com.socialMedia.bloggingApplication.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {
    @Autowired
    private PostServices postServices;

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("/addPost")
    public String addPost(@RequestBody Posts post){

        String result = postServices.addPost(post);
        return result;
    }
    @GetMapping("/findAllPosts")
    public List<Posts> getPosts() {

        return postServices.findAll();
    }
    @GetMapping("/findPostById/{id}")
    public Optional<Posts> getPost(@PathVariable String id) {

        return postServices.findPostById(id);
    }
    @RequestMapping("/updatePost/{id}")
    public String updateUser(@RequestBody Posts post,  @PathVariable String id){
        String result =postServices.updatePost(post,id);
        return result;
    }

    @DeleteMapping("/deletePost/{id}")
    public String deletePost(@PathVariable String id){
        postServices.deleteById(id);
        return "Deleted Successfully";
    }
}
