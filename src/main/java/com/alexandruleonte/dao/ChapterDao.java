package com.alexandruleonte.dao;

import com.alexandruleonte.entities.Chapter;
import com.alexandruleonte.entities.Platform;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Stateless
@Named
public class ChapterDao {

    @PersistenceContext(name = "default")
    EntityManager em;

    public Collection<Chapter> getChapters() {
        Platform p1 = em.find(Platform.class, 1);
        return p1.getChapters();
    }

    public void saveChapter(Chapter chapter, int platformId) {
        Platform platform = em.find(Platform.class, platformId);
        chapter.setPlatform(platform);
        em.persist(chapter);
    }
}
