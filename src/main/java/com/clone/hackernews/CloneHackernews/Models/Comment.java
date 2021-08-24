package com.clone.hackernews.CloneHackernews.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String description;
    @JsonBackReference
    @ManyToOne
    private Post post;
    @OneToOne(cascade = CascadeType.ALL)
    private Comment parent;
    @CreationTimestamp
    private Timestamp timeZone;

    public Comment() {

    }
    public Comment(UUID id, String description, Timestamp timeZone) {
        this.id = id;
        this.description = description;
        this.timeZone = timeZone;
        this.parent = new Comment();
        this.post = new Post();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setParent(Comment parent) {
        this.parent = parent;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void setTimeZone(Timestamp timeZone) {
        this.timeZone = timeZone;
    }

    public Comment getParent() {
        return parent;
    }

    public Post getPost() {
        return post;
    }

    public String getDescription() {
        return description;
    }

    public Timestamp getTimeZone() {
        return timeZone;
    }

    public UUID getId() {
        return id;
    }
}
