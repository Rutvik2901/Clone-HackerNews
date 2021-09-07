package com.clone.hackernews.CloneHackernews.Repository;

import com.clone.hackernews.CloneHackernews.Models.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends CrudRepository<Post, UUID> {
    List<Post> findAll(Sort createdAt);

    @Query("from Post p where LOWER(p.title) LIKE %?#{[0]}% OR LOWER(p.author) LIKE %?#{[0]}% OR LOWER(p.description) LIKE %?#{[0]}% ORDER BY createdAt DESC")
    List<Post> findByvalueContainingIgnoreCase(String value);

    List<Post> findByOrderByVotesDesc();
}
