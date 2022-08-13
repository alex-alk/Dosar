package com.alexandruleonte.api;

import com.alexandruleonte.dao.PlatformDao;
import com.alexandruleonte.entities.Platform;
import com.alexandruleonte.service.MapValidationErrorService;

import javax.inject.Inject;
import javax.validation.*;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Path("platforms")

public class PlatformRest {

    private final PlatformDao platformDao;

    private final MapValidationErrorService errorService;

    @Inject
    public PlatformRest(PlatformDao platformDao, MapValidationErrorService errorService) {
        this.platformDao = platformDao;
        this.errorService = errorService;
    }

    @GET
    public Response platforms() {
        return Response.ok(platformDao.getPlatforms()).build();
    }

    @GET
    @Path("{id}")
    public Response getPlatformById(@PathParam("id") int id) {
        Platform p = platformDao.getPlatform(id);
        if (p == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Platform ID '" + id + "' does not exist").build();
        }
        return Response.ok(p).build();
    }

    @POST
    public Response createPlatform(Platform platform) {

        Response errorMap = errorService.getErrorMap(platform);
        if (errorMap != null) return errorMap;

        try {
            platformDao.save(platform);
        } catch (Exception e) {
            Response.status(Response.Status.BAD_REQUEST).entity("Platform name must be unique").build();
        }
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("{id}")
    public Response deletePlatform(@PathParam("id") int id) {
        Platform p = platformDao.getPlatform(id);
        if (p == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Platform ID '" + id + "' does not exist").build();
        }
        platformDao.delete(p);
        return Response.ok().build();
    }

    @PATCH
    public Response editPlatform(Platform platform) {
        Response errorMap = errorService.getErrorMap(platform);
        if (errorMap != null) return errorMap;

        Platform p = platformDao.getPlatform(platform.getId());
        if (p == null) {
            Map<String, String> error = new HashMap<>();
            error.put("name", "Platform ID '" + platform.getId() + "' does not exist");
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }
        platformDao.update(platform);
        return Response.ok().build();
    }
}
