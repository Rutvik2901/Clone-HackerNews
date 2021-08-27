package com.clone.hackernews.CloneHackernews.Services;

import com.clone.hackernews.CloneHackernews.Models.Comment;
import com.clone.hackernews.CloneHackernews.Models.Post;
import com.clone.hackernews.CloneHackernews.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPost() {
        return (List<Post>) postRepository.findAll();
    }

    public Optional<Post> getPostById(UUID id) {
        return postRepository.findById(id);
    }

    public void savePost(Post post) {
        postRepository.save(post);
    }

    public void likePost(String postId) {
        Post postById = postRepository.findById(UUID.fromString(postId)).get();
        postById.setVotes(postById.getVotes() + 1);
        postRepository.save(postById);
    }

    public List<Comment> getComment(String postId) {
        return postRepository.findById(UUID.fromString(postId)).get().getComment();
    }
}
