package com.alexandruleonte;

import com.alexandruleonte.dao.ChapterContentDao;
import com.alexandruleonte.dao.ChapterDao;
import com.alexandruleonte.dao.PlatformDao;
import com.alexandruleonte.entities.Chapter;
import com.alexandruleonte.entities.ChapterContent;
import com.alexandruleonte.entities.Platform;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;
import java.util.List;

@Named
@RequestScoped
public class AdminHomeController {
    //todo: add only jar to container

    @Inject
    PlatformDao platformDao;
    @Inject
    ChapterDao chapterDao;
    @Inject
    ChapterContentDao chapterContentDao;

    private final Platform platform = new Platform();
    private final Chapter chapter = new Chapter();
    private final ChapterContent chapterContent = new ChapterContent();

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
        platformDao.save(platform);
        return "home";
    }

    public String saveChapter(Chapter chapter, int platformId) {
        chapterDao.saveChapter(chapter, platformId);
        return "/admin/index?faces-redirect=true";
    }

    public String saveChapterContent(ChapterContent chapterContent, int chapterId) {
        chapterContentDao.saveChapterContent(chapterContent, chapterId);
        return "/admin/index?faces-redirect=true";
    }
}
