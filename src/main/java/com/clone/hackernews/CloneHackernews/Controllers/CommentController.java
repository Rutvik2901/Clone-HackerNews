package com.clone.hackernews.CloneHackernews.Controllers;

import com.clone.hackernews.CloneHackernews.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @CrossOrigin(value = {"http://localhost:3000","https://hackernews-clone-rutvik.herokuapp.com"})
    @PostMapping(value = { "/comment/post/{postId}", "/comment/post/{postId}/parent/{parentId}" })
    public void addComment(@PathVariable String postId,
                           @PathVariable(required = false) String parentId,
                           @RequestBody String description) {
        commentService.addComment(postId, parentId, description);
    }
}
