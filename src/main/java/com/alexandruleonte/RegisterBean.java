package com.alexandruleonte;

import com.alexandruleonte.dao.ChapterDao;
import com.alexandruleonte.dao.UserDao;
import com.alexandruleonte.entities.User;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class RegisterBean implements Serializable {

    @Inject
    UserDao userDao;

    private final User user = new User();

    public User getUser() {
        return user;
    }

    public int getUsersCount() {
        return userDao.getUsers().size();
    }

    // only one user can register
    public String register(User user) {

        List<User> users = userDao.getUsers();

        if (users.size() == 0) {
            userDao.save(user);
        }

        return "/admin/home?faces-redirect=true";
    }
}