package com.alexandruleonte.api;

import com.alexandruleonte.dao.PlatformDao;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    @Path("{name}")
    public String platformsByName(@PathParam("name") String name) {
        return name + "abc";
    }

}
