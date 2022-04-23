package com.alexandruleonte;

import com.alexandruleonte.dao.ChapterDao;
import com.alexandruleonte.entities.Chapter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class HomeBean {

    @Inject
    ChapterDao chapterDao;

    public Chapter getChapter(int id) {
        return chapterDao.getChapter(id);
    }
}
