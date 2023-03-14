package com.example.path_finder.domain.entities;

import com.example.path_finder.domain.enums.Levels;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity{

    @Column(name = "gpx_coordinates", columnDefinition = "LONGTEXT")
    private String coordinates;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private Levels level;

    @Column
    private String name;

    @ManyToOne
    private User author;

    @OneToMany(targetEntity = Picture.class,
            fetch = FetchType.EAGER,
            mappedBy = "route",
            cascade = {CascadeType.MERGE, CascadeType.DETACH})
    private Set<Picture> pictures;

    @OneToMany(targetEntity = Comment.class,
            mappedBy = "route",
            cascade = {CascadeType.MERGE, CascadeType.DETACH})
    private Set<Comment> comments;

    @ManyToMany
    private Set<Category> categories;

    @Column(name = "video_url")
    private String video;




    public String getCoordinates() {
        return coordinates;
    }

    public Route setCoordinates(String coordinates) {
        this.coordinates = coordinates;
        return this;
    }

    public Levels getLevel() {
        return level;
    }

    public Route setLevel(Levels level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public Route setName(String name) {
        this.name = name;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Route setAuthor(User author) {
        this.author = author;
        return this;
    }

    public String getVideo() {
        return video;
    }

    public Route setVideo(String video) {
        this.video = video;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Route setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<Picture> getPictures() {
        return this.pictures;
    }

    public Route setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }

    public Set<Comment> getComments() {
        return this.comments;
    }

    public Route setComments(Set<Comment> comments) {
        this.comments = comments;
        return this;
    }
}
