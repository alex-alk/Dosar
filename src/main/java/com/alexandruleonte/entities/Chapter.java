package com.alexandruleonte.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "chapters")
@NamedQuery(name = Chapter.GET_CHAPTERS, query = "select c from Chapter c")
public class Chapter {

    public static final String GET_CHAPTERS = "Chapter.getAll";

    @Id
    Integer id;

    @ManyToOne()
    @JoinColumn(name = "PLATFORM_ID")
    private Platform platform;

    @NotEmpty(message = "Name must be set")
    private String name;

    @NotNull
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
