package com.alexandruleonte;

import com.alexandruleonte.entities.Chapter;
import com.alexandruleonte.entities.Platform;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Named
@RequestScoped
public class Home {
    //todo: add only jar to container
    @PersistenceContext(name = "default")
    EntityManager em;

    private final Platform platform = new Platform();

    public List<Platform> getPlatforms() {
        return em.createNamedQuery(Platform.GET_PLATFORMS, Platform.class).getResultList();
    }

    public Collection<Chapter> getChapters() {
        Platform p1 = em.find(Platform.class, 1);
        return p1.getChapters();
    }

    public Platform getPlatform() {
        return platform;
    }


    public String save(Platform platform) {
        return "home";
    }
}
