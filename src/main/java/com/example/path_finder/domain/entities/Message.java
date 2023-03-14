package com.example.path_finder.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message extends BaseEntity{

    @Column(name = "date_time")
    private LocalDateTime time;

    @Column(columnDefinition = "TEXT", name = "text_content")
    private String content;

    @ManyToOne
    private User author;

    @ManyToOne
    private User recipient;

    public LocalDateTime time() {
        return this.time;
    }

    public Message setTime(LocalDateTime time) {
        this.time = time;
        return this;
    }

    public String getContent() {
        return this.content;
    }

    public Message setContent(String content) {
        this.content = content;
        return this;
    }

    public User getAuthor() {
        return this.author;
    }

    public Message setAuthor(User author) {
        this.author = author;
        return this;
    }

    public User getRecipient() {
        return this.recipient;
    }

    public Message setRecipient(User recipient) {
        this.recipient = recipient;
        return this;
    }
}
