package com.alexandruleonte.api;

import com.alexandruleonte.dao.PlatformDao;
import com.alexandruleonte.entities.Platform;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("platforms")

public class PlatformRest {

    @Inject
    PlatformDao platformDao;

    @GET
    public Response platforms() {
        return Response.ok(platformDao.getPlatforms()).build();
    }

    @GET
    @Path("{id}")
    public Response getPlatformById(@PathParam("id") int id) {
        return Response.ok(platformDao.getPlatform(id)).build();
    }

    @POST
    public Response createPlatform(Platform platform) {
        platformDao.save(platform);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("{id}")
    public Response deletePlatform(@PathParam("id") int id) {
        platformDao.delete(platformDao.getPlatform(id));
        return Response.ok().build();
    }

    @PATCH
    public Response editPlatform(Platform platform) {
        platformDao.update(platform);
        return Response.ok().build();
    }
}
