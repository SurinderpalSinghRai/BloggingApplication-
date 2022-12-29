package com.socialMedia.bloggingApplication.services;

import com.socialMedia.bloggingApplication.entities.Comments;
import com.socialMedia.bloggingApplication.entities.Posts;
import com.socialMedia.bloggingApplication.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServices {

    @Autowired
    private CommentsRepository commentsRepository;
    public String addComment(Comments comment) {
        Comments getcomment = commentsRepository.save(comment);
        if(getcomment.equals(comment)) {
            return "comment added successfully";
        }
        else {
            return "There is some issue";
        }
    }

    public List<Comments> findAll() {
        return commentsRepository.findAll();
    }

    public String updateComment(Comments comment , String id) {
        Optional<Comments> getComment = commentsRepository.findById(id);
        if(getComment.isPresent()){
            commentsRepository.save(comment);
            return "Comment updated successsfullly";
        }
        else {
            return "Comment not find";
        }

    }

    public void deleteById(String id) {
        commentsRepository.deleteById(id);

    }

    public Optional<Comments> findCommentById(String id) {
        return commentsRepository.findById(id);
    }
}
