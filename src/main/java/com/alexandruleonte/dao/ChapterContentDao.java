package com.alexandruleonte.dao;

import com.alexandruleonte.entities.Chapter;
import com.alexandruleonte.entities.ChapterContent;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Named
public class ChapterContentDao {

    @PersistenceContext(name = "default")
    EntityManager em;

    public void saveChapterContent(ChapterContent chapterContent, int chapterId) {
        Chapter chapter = em.find(Chapter.class, chapterId);
        chapterContent.setChapter(chapter);
        em.persist(chapterContent);
    }
}
