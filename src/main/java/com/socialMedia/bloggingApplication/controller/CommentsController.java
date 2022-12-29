package com.socialMedia.bloggingApplication.controller;

import com.socialMedia.bloggingApplication.entities.Comments;
import com.socialMedia.bloggingApplication.entities.Posts;
import com.socialMedia.bloggingApplication.entities.Users;
import com.socialMedia.bloggingApplication.repository.CommentsRepository;
import com.socialMedia.bloggingApplication.repository.UsersRepository;
import com.socialMedia.bloggingApplication.services.CommentServices;
import com.socialMedia.bloggingApplication.services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class CommentsController {

    @Autowired
    private CommentServices commentServices;

    @Autowired
    private CommentsRepository commentsRepository;

    @PostMapping("/addComment")
    public String addComment(@RequestBody Comments comment){

        String result = commentServices.addComment(comment);
        return result;
    }
    @GetMapping("/findAllComments")
    public List<Comments> getComments() {

        return commentServices.findAll();
    }
    @GetMapping("/findCommentById/{id}")
    public Optional<Comments> getComment(@PathVariable String id) {

        return commentServices.findCommentById(id);
    }
    @RequestMapping("/updateComment/{id}")
    public String updateComment(@RequestBody Comments comment,  @PathVariable String id){
        String result =commentServices.updateComment(comment,id);
        return result;
    }

    @DeleteMapping("/deleteComment/{id}")
    public String deleteComment(@PathVariable String id){
        commentServices.deleteById(id);
        return "Deleted Successfully";
    }
}
