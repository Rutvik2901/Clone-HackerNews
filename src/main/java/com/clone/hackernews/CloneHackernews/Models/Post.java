package com.clone.hackernews.CloneHackernews.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private String description;
    private String author;
    private int votes;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comment;
    private String url;

    public Post() {

    }
    public Post(UUID id, String title, String description, String author, int votes, String url) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.votes = votes;
        this.url = url;
        this.comment = new ArrayList<>();
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public String getDescription() {
        return description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVotes() {
        return votes;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
