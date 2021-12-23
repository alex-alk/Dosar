package com.alexandruleonte.api;

import com.alexandruleonte.dao.UserDao;
import com.alexandruleonte.entities.User;
import com.alexandruleonte.security.TokenIssuer;
import org.mindrot.jbcrypt.BCrypt;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("register")
public class RegisterRest {

    @Inject
    UserDao userDao;

    @Inject
    TokenIssuer issuer;

    // only 1 user
    @POST
    public Response register(User user) {

        List<User> users = userDao.getUsers();

        if (users.size() == 0) {
            userDao.save(user);
            return Response.ok().build();
        }
        return Response.serverError().build();
    }
}
