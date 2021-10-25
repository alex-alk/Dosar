package com.alexandruleonte.api;

import com.alexandruleonte.dao.ChapterDao;
import com.alexandruleonte.dao.PlatformDao;
import com.alexandruleonte.entities.Chapter;
import com.alexandruleonte.entities.Platform;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("chapters")

public class ChapterRest {

    @Inject
    ChapterDao chapterDao;

    @GET
    public Response chapters() {
        return Response.ok(chapterDao.getChapters()).build();
    }

    @GET
    @Path("{id}")
    public Response getChapterById(@PathParam("id") int id) {
        return Response.ok(chapterDao.getChapter(id)).build();
    }

    @POST
    public Response createChapter(Chapter chapter) {
        chapterDao.save(chapter);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteChapter(@PathParam("id") int id) {
        chapterDao.delete(chapterDao.getChapter(id));
        return Response.ok().build();
    }

    @PATCH
    public Response editChapter(Chapter chapter) {
        chapterDao.update(chapter);
        return Response.ok().build();
    }
}
