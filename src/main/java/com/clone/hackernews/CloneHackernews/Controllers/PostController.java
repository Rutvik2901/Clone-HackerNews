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
    public List<Post> getAllPost(@RequestParam(required = false) Optional<String> search,
            @RequestParam(required = false) Optional<String> older,
            @RequestParam(required = false) Optional<String> votes) {
        if (search.isPresent()) {
            return postService.findBySearch(search.get());
        } else if (votes.isPresent()) {
            return postService.findAllByVotes();
        } else if (older.isPresent()) {
            return postService.getAllPost(true);
        }
        return postService.getAllPost(false);
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

    @PutMapping(value = "/like/post/{postId}")
    public void likePost(@PathVariable String postId) {
        postService.likePost(postId);
    }

    @PutMapping(value = "/dislike/post/{postId}")
    public void dislikePost(@PathVariable String postId) {
        postService.dislikePost(postId);
    }

    @GetMapping(value = "/comment/post/{postId}")
    public List<Comment> getComment(@PathVariable String postId) {
        return postService.getComment(postId);
    }
}
