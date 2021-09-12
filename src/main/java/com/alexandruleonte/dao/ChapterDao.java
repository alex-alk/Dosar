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
        return em.createNamedQuery(Chapter.GET_CHAPTERS, Chapter.class).getResultList();
    }

    public void saveChapter(Chapter chapter, int platformId) {
        Platform platform = em.find(Platform.class, platformId);
        chapter.setPlatform(platform);
        em.persist(chapter);
    }

    public void update(Chapter chapter) {
        em.merge(chapter);
    }

    public Chapter getChapter(int id) {
        return em.find(Chapter.class, id);
    }

    public void delete(Chapter chapter) {
        chapter = em.merge(chapter);
        em.remove(chapter);
    }
}
