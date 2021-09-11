package com.alexandruleonte;

import com.alexandruleonte.dao.ChapterDao;
import com.alexandruleonte.entities.Chapter;
import com.alexandruleonte.entities.Platform;
import org.omnifaces.cdi.Param;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;

@Named
@RequestScoped
public class HomeBean {

    @Inject
    ChapterDao chapterDao;

    @Param
    private int id;

    public Chapter getChapter() {
        return chapterDao.getChapter(id);
    }
}
