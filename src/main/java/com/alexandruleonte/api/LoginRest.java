package com.alexandruleonte.api;

import com.alexandruleonte.dao.UserDao;
import com.alexandruleonte.entities.User;
import com.alexandruleonte.security.TokenIssuer;
import org.mindrot.jbcrypt.BCrypt;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("authenticate")
public class LoginRest {

    private final UserDao userDao;

    private final TokenIssuer issuer;

    @Inject
    public LoginRest(UserDao userDao, TokenIssuer issuer) {
        this.userDao = userDao;
        this.issuer = issuer;
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(User user) {

        String token = null;
        if (userDao.getUsers().size() != 0) {

            if (userDao.getUserByUsername(user.getUsername()).size() > 0) {
                User userDB = userDao.getUserByUsername(user.getUsername()).get(0);

                String userPass = user.getPassword();
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
}
