package com.alexandruleonte.entities;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "platforms")
@NamedQuery(name = Platform.GET_PLATFORMS, query = "select p from Platform p")
public class Platform {

    public static final String GET_PLATFORMS = "Platform.getAll";

    @OneToMany(mappedBy = "platform")
    private Collection<Chapter> chapters = new ArrayList<>();

    @Id
    Integer id;

    @NotNull
    private String name;

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
