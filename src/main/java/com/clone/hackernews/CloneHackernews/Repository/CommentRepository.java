package com.clone.hackernews.CloneHackernews.Repository;


import com.clone.hackernews.CloneHackernews.Models.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CommentRepository extends CrudRepository<Comment, UUID> {
}
