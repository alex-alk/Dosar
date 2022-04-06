package com.alexandruleonte.dao;

import com.alexandruleonte.entities.Platform;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@Named
public class PlatformDao {
    @PersistenceContext(name = "default")
    EntityManager em;

    public List<Platform> getPlatforms() {
        return em.createNamedQuery(Platform.GET_PLATFORMS, Platform.class).getResultList();
    }

    public void save(Platform platform) {
        em.persist(platform); 
    }

    public void update(Platform platform) {
        em.merge(platform);
    }

    public void delete(Platform platform) {
        platform = em.merge(platform);
        em.remove(platform);
    }

    public Platform getPlatform(int id) {
        return em.find(Platform.class, id);
    }
}
