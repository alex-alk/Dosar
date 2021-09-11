package com.alexandruleonte;

import com.alexandruleonte.dao.ChapterDao;
import com.alexandruleonte.dao.PlatformDao;
import com.alexandruleonte.entities.Chapter;
import com.alexandruleonte.entities.Platform;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AdminHomeBean {
    //todo: add only jar to container

    @Inject
    PlatformDao platformDao;
    @Inject
    ChapterDao chapterDao;

    private final Platform platform = new Platform();
    private final Chapter chapter = new Chapter();

    public Platform getPlatform() {
        return platform;
    }
    public Chapter getChapter() {
        return chapter;
    }


    public String save(Platform platform) {
        platformDao.save(platform);
        return "/admin/platform/create?faces-redirect=true";
    }

    public String saveChapter(Chapter chapter, int platformId) {
        chapterDao.saveChapter(chapter, platformId);
        return "/admin/chapter/create?faces-redirect=true";
    }
}
