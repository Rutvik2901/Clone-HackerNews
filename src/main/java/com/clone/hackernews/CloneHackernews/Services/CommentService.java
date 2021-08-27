package com.clone.hackernews.CloneHackernews.Services;

import com.clone.hackernews.CloneHackernews.Models.Comment;
import com.clone.hackernews.CloneHackernews.Models.Post;
import com.clone.hackernews.CloneHackernews.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostService postService;

    public void addComment(String postId, String parentId, String description) {
        Comment newComment = new Comment();

        if (parentId == null) {
            newComment.setParent(null);
        } else {

            Optional<Comment> commentById = getCommentById(UUID.fromString(parentId));

            commentById.ifPresent(newComment::setParent);
        }
        newComment.setDescription(description);

        Optional<Post> postById = postService.getPostById(UUID.fromString(postId));

        List<Comment> commentsFromPost = postById.get().getComment();
        commentsFromPost.add(newComment);
        newComment.setPost(postById.get());
        commentRepository.save(newComment);
        postById.get().setComment(commentsFromPost);
        postService.savePost(postById.get());
    }

    public Optional<Comment> getCommentById(UUID id) {
        return commentRepository.findById(id);
    }
}
