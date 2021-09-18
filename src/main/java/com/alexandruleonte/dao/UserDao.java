package com.alexandruleonte.dao;

import com.alexandruleonte.entities.Platform;
import com.alexandruleonte.entities.User;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@Named
public class UserDao {
    @PersistenceContext(name = "default")
    EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public User getUser(int id) {
        return em.find(User.class, id);
    }
}
