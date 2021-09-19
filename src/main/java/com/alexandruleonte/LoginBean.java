package com.alexandruleonte;

import com.alexandruleonte.dao.UserDao;
import com.alexandruleonte.entities.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginBean implements Serializable {

    private boolean isAdmin;

    @Inject
    UserDao userDao;

    private final User user = new User();

    public User getUser() {
        return user;
    }

    public String validateUserLogin(User user) {

        String navResult = "/admin/login";

        if (userDao.getUsers().size() != 0) {
            User userDB = userDao.getUserByUserName(user.getUserName());
            String userPass = encrypt(user.getPassword());
            if (BCrypt.checkpw(userPass, userDB.getPassword())) {
                navResult = "/admin/home?faces-redirect=true";
                isAdmin = true;
            }
        }

        return navResult;
    }

    public String logout()
    {
        isAdmin = false;
        return "/admin/login?faces-redirect=true";
    }

    private String encrypt(String t)
    {
        return t;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }
}