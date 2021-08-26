package com.alexandruleonte.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "chapters")
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "PLATFORM_ID")
    private Platform platform;

    @OneToMany(mappedBy = "chapter")
    private Collection<ChapterContent> content = new ArrayList<>();

    @NotEmpty(message = "Name must be set")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<ChapterContent> getContent() {
        return content;
    }

    public void setContent(Collection<ChapterContent> content) {
        this.content = content;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }
}
