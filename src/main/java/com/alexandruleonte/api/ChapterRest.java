package com.alexandruleonte.api;

import com.alexandruleonte.dao.ChapterDao;
import com.alexandruleonte.entities.Chapter;
import com.alexandruleonte.entities.Platform;
import com.alexandruleonte.service.MapValidationErrorService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("chapters")

public class ChapterRest {

    private final ChapterDao chapterDao;

    private final MapValidationErrorService errorService;

    @Inject
    public ChapterRest(ChapterDao chapterDao, MapValidationErrorService errorService) {
        this.chapterDao = chapterDao;
        this.errorService = errorService;
    }

    @GET
    public Response chapters() {
        return Response.ok(chapterDao.getChapters()).build();
    }

    @GET
    @Path("{id}")
    public Response getChapterById(@PathParam("id") int id) {
        Chapter c = chapterDao.getChapter(id);
        if (c == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Chapter ID '" + id + "' does not exist").build();
        }
        return Response.ok(c).build();
    }

    @POST
    public Response createChapter(Chapter chapter) {
        Response errorMap = errorService.getErrorMap(chapter);
        if (errorMap != null) return errorMap;

        chapterDao.save(chapter);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteChapter(@PathParam("id") int id) {
        Chapter c = chapterDao.getChapter(id);
        if (c == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Chapter ID '" + id + "' does not exist").build();
        }
        chapterDao.delete(chapterDao.getChapter(id));
        return Response.ok().build();
    }

    @PATCH
    public Response editChapter(Chapter chapter) {

        Response errorMap = errorService.getErrorMap(chapter);
        if (errorMap != null) return errorMap;

        Chapter c = chapterDao.getChapter(chapter.getId());
        if (c == null) {
            Map<String, String> error = new HashMap<>();
            error.put("name", "Chapter ID '" + chapter.getId() + "' does not exist");
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
        chapterDao.update(chapter);
        return Response.ok().build();
    }
}
