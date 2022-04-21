package com.alexandruleonte.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

@Entity
@Table(name = "chapters")
@NamedQuery(name = Chapter.GET_CHAPTERS, query = "select c from Chapter c")
public class Chapter {

    public static final String GET_CHAPTERS = "Chapter.getAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    //@JsonbTransient
    @ManyToOne()
    @JoinColumn(name = "PLATFORM_ID")
    private Platform platform;

    @NotEmpty(message = "Name must be set")
    @Column(length = 100)
    private String name;

    @NotEmpty(message = "Content is required")
    @Lob
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

    public String getUrlName() {
        Pattern NONLATIN = Pattern.compile("[^\\w-]");
        Pattern WHITESPACE = Pattern.compile("[\\s]");

        String nowhitespace = WHITESPACE.matcher(name).replaceAll("-");
        String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH);
    }
}
