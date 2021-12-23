package com.alexandruleonte.api;

import com.alexandruleonte.dao.PlatformDao;
import com.alexandruleonte.dao.UserDao;
import com.alexandruleonte.entities.Platform;
import com.alexandruleonte.entities.User;
import com.alexandruleonte.security.TokenIssuer;
import org.mindrot.jbcrypt.BCrypt;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("authenticate")
public class LoginRest {

    @Inject
    UserDao userDao;

    @Inject
    TokenIssuer issuer;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(User user) {

        String token = null;
        if (userDao.getUsers().size() != 0) {

            if (userDao.getUserByUsername(user.getUsername()).size() > 0) {
                User userDB = userDao.getUserByUsername(user.getUsername()).get(0);

                String userPass = encrypt(user.getPassword());
                if (BCrypt.checkpw(userPass, userDB.getPassword())) {
                    token = issuer.issueToken(user.getUsername());
                }
            }
        }

        if (token != null) {
            return Response.ok(token).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .build();
        }
    }

    private String encrypt(String t) {
        return t;
    }
}
