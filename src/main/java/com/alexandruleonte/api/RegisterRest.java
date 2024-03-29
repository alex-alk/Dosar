package com.alexandruleonte.api;

import com.alexandruleonte.dao.UserDao;
import com.alexandruleonte.entities.User;
import com.alexandruleonte.security.TokenIssuer;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("register")
public class RegisterRest {

    private final UserDao userDao;

    @Inject
    public RegisterRest(UserDao userDao) {
        this.userDao = userDao;
    }

    // only 1 user
    @POST
    public Response register(User user) {

        List<User> users = userDao.getUsers();

        if (users.size() == 0) {
            userDao.save(user);
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Maximum 1 user").build();
        }
    }
}
