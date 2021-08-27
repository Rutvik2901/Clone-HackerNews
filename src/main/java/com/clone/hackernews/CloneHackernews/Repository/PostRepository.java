package com.clone.hackernews.CloneHackernews.Repository;

import com.clone.hackernews.CloneHackernews.Models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PostRepository extends CrudRepository<Post, UUID> {
}
