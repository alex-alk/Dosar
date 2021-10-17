package com.alexandruleonte.api;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("platforms")
public class PlatformRest {

    @GET
    public String platforms() {
        return "abc";
    }

    @GET
    @Path("{name}")
    public String platformsByName(@PathParam("name") String name) {
        return name + "abc";
    }

}
