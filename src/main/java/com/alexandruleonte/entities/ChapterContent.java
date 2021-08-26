package com.alexandruleonte.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Table(name = "chapter_content")
public class ChapterContent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @NotNull
    private String content;

    @ManyToOne
    @JoinColumn(name = "CHAPTER_ID")
    private Chapter chapter;

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
    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }
}
