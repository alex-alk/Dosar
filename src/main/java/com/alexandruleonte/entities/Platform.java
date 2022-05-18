package com.alexandruleonte.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "platforms")
@NamedQuery(name = Platform.GET_PLATFORMS, query = "select p from Platform p")
public class Platform {

    public static final String GET_PLATFORMS = "Platform.getAll";

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "platform", cascade = CascadeType.REMOVE)
    @OrderBy("name ASC")
    private Collection<Chapter> chapters = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotBlank(message = "Name is required")
    @Column(length = 100, unique = true)
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(Collection<Chapter> chapters) {
        this.chapters = chapters;
    }
}
