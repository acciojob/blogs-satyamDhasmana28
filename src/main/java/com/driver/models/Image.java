package com.driver.models;

import javax.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String description;
    private String dimensions;
//    connecting to blog
    @ManyToOne
    @JoinColumn
    private Blog blog;

    public Image(String description, String dimensions) {
        this.description=description;
        this.dimensions=dimensions;
    }
    //    getter,setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
//    Constructor

    public Image(int id, String description, String dimensions, Blog blog) {
        this.id = id;
        this.description = description;
        this.dimensions = dimensions;
        this.blog = blog;
    }

    public Image() {
    }
}