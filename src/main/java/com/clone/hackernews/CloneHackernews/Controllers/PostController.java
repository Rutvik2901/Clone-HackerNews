package com.clone.hackernews.CloneHackernews.Controllers;

import com.clone.hackernews.CloneHackernews.Models.Comment;
import com.clone.hackernews.CloneHackernews.Models.Post;
import com.clone.hackernews.CloneHackernews.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/post")
    public List<Post> getAllPost() {
        return postService.getAllPost();
    }

    @GetMapping("/post/{id}")
    public Object getPostById(@RequestParam UUID id) {
        Optional<Post> postById = postService.getPostById(id);
        if (postById.isPresent()) {
            return postById.get();
        } else {
            return new ResponseEntity<>("post not Exists", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/post")
    public void savePost(@RequestBody Post post) {
        postService.savePost(post);
    }

    @CrossOrigin(value = "http://localhost:3000")
    @PutMapping(value = "/like/post/{postId}")
    public void likePost(@PathVariable String postId) {
        postService.likePost(postId);
    }

    @CrossOrigin(value = "http://localhost:3000")
    @GetMapping(value = "/comment/post/{postId}")
    public List<Comment> getComment(@PathVariable String postId) {
        return postService.getComment(postId);
    }
}
