package com.google.sps.entity;

public class Comment {
    private String name;
    private String email;
    private String comment;

    public Comment(final String name, final String email,
                   final String comment) {
        this.name    = name;
        this.email   = email;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(final String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" + "name='" + name + '\'' + ", email='" + email +
               '\'' + ", comment='" + comment + '\'' + '}';
    }
}
