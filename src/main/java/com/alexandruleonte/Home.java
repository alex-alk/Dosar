package com.alexandruleonte;

import com.alexandruleonte.entities.Chapter;
import com.alexandruleonte.entities.ChapterContent;
import com.alexandruleonte.entities.Platform;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Named
@RequestScoped
@Transactional
public class Home {
    //todo: add only jar to container
    @PersistenceContext(name = "default")
    EntityManager em;

    private final Platform platform = new Platform();
    private final Chapter chapter = new Chapter();
    private final ChapterContent chapterContent = new ChapterContent();

    public List<Platform> getPlatforms() {
        em.getEntityManagerFactory().getCache().evictAll();
        return em.createNamedQuery(Platform.GET_PLATFORMS, Platform.class).getResultList();
    }

    public Collection<Chapter> getChapters() {
        Platform p1 = em.find(Platform.class, 1);
        return p1.getChapters();
    }

    public Platform getPlatform() {
        return platform;
    }
    public Chapter getChapter() {
        return chapter;
    }
    public ChapterContent getChapterContent() {
        return chapterContent;
    }


    public String save(Platform platform) {
        em.persist(platform);
        return "home";
    }

    public String saveChapter(Chapter chapter, int platformId) {

        Platform platform = em.find(Platform.class, platformId);
        chapter.setPlatform(platform);
        em.persist(chapter);
        return "/admin/index?faces-redirect=true";
    }

    public String saveChapterContent(ChapterContent chapterContent, int chapterId) {

        Chapter chapter = em.find(Chapter.class, chapterId);
        chapterContent.setChapter(chapter);
        em.persist(chapterContent);
        return "/admin/index?faces-redirect=true";
    }
}
