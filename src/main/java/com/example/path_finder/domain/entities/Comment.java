package com.example.path_finder.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity{

    @Column
    private Boolean approved;

    @Column
    private LocalDateTime created;

    @Column(columnDefinition = "TEXT", name = "text_content")
    private String content;

    @ManyToOne
    private User author;

    @ManyToOne
    private Route route;



    public Boolean getApproved() {
        return this.approved;
    }

    public Comment setApproved(Boolean approved) {
        this.approved = approved;
        return this;
    }

    public LocalDateTime getCreated() {
        return this.created;
    }

    public Comment setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public String getContent() {
        return this.content;
    }

    public Comment setContent(String content) {
        this.content = content;
        return this;
    }

    public User getAuthor() {
        return this.author;
    }

    public Comment setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Route getRoute() {
        return this.route;
    }

    public Comment setRoute(Route route) {
        this.route = route;
        return this;
    }
}
