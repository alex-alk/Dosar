package com.alexandruleonte.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "platforms")
@NamedQuery(name = Platform.GET_PLATFORMS, query = "select p from Platform p")
public class Platform {

    public static final String GET_PLATFORMS = "Platform.getAll";

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "platform", cascade = CascadeType.REMOVE)
    private Collection<Chapter> chapters = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotEmpty(message = "Name is required")
    @Column(length = 100)
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
