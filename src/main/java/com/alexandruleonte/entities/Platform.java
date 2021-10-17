package com.alexandruleonte.entities;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.json.bind.annotation.JsonbTransient;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_gen_platform")
    @SequenceGenerator(sequenceName = "platforms_seq", allocationSize = 1, name = "sec_gen_platform")
    Integer id;

    @NotNull
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
