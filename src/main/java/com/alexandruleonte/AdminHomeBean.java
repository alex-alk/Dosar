package com.alexandruleonte;

import com.alexandruleonte.dao.ChapterDao;
import com.alexandruleonte.dao.PlatformDao;
import com.alexandruleonte.entities.Chapter;
import com.alexandruleonte.entities.Platform;
import org.omnifaces.cdi.Param;
import org.omnifaces.cdi.ViewScoped;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class AdminHomeBean implements Serializable {
    //todo: add only jar to container

    @Inject
    PlatformDao platformDao;
    @Inject
    ChapterDao chapterDao;
    @Inject
    LoginBean loginBean;

    @Param
    private int id;

    private Platform editPlatform;
    private Chapter editChapter;

    private final Platform platform = new Platform();
    private final Chapter chapter = new Chapter();

    public Platform getPlatform() {
        return platform;
    }
    public Chapter getChapter() {
        return chapter;
    }

    public String save(Platform platform) {
        if (loginBean.getIsAdmin()) {
            platformDao.save(platform);
        }
        return "/admin/platform/list.xhtml?faces-redirect=true";
    }

    public String update(Platform platform) {
        if (loginBean.getIsAdmin()) {
            this.editPlatform = platform;
            platformDao.update(platform);
        }
        return "/admin/platform/list.xhtml?faces-redirect=true";
    }

    public String updateChapter(Chapter chapter) {
        if (loginBean.getIsAdmin()) {
            this.editChapter = chapter;
            chapterDao.update(chapter);
        }
        return "/admin/chapter/list.xhtml?faces-redirect=true";
    }

    public String delete(Platform platform) {
        if (loginBean.getIsAdmin()) {
            platformDao.delete(platform);
        }
        return "/admin/platform/list.xhtml?faces-redirect=true";
    }

    public String deleteChapter(Chapter chapter) {
        if (loginBean.getIsAdmin()) {
            chapterDao.delete(chapter);
        }
        return "/admin/chapter/list.xhtml?faces-redirect=true";
    }

    public String saveChapter(Chapter chapter, int platformId) {
        if (loginBean.getIsAdmin()) {
            chapterDao.saveChapter(chapter, platformId);
        }
        return "/admin/chapter/list?faces-redirect=true";
    }

    public Platform getPlatformEdit() {
        if (this.editPlatform == null) {
            editPlatform = platformDao.getPlatform(id);
        }
        return editPlatform;
    }

    public Chapter getChapterEdit() {
        if (this.editChapter == null) {
            editChapter = chapterDao.getChapter(id);
        }
        return editChapter;
    }
}
