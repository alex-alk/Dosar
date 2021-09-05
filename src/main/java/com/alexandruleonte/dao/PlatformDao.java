package com.alexandruleonte.dao;

import com.alexandruleonte.entities.Platform;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PlatformDao {
    @PersistenceContext(name = "default")
    EntityManager em;

    public List<Platform> getPlatforms() {
        return em.createNamedQuery(Platform.GET_PLATFORMS, Platform.class).getResultList();
    }

    public void save(Platform platform) {
        em.persist(platform);
    }
}
