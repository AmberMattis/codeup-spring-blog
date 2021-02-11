package com.codeup.springblog.models;

public class Post {
    private String title;
    private String body;
    private Long id;

    public Post( String title, String body, Long id) {
        this.title = title;
        this.body = body;
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
