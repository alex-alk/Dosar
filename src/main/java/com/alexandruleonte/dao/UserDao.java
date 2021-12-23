package com.alexandruleonte.dao;

import com.alexandruleonte.entities.User;
import org.mindrot.jbcrypt.BCrypt;

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

        String salt = BCrypt.gensalt();
        String newPassword = BCrypt.hashpw(user.getPassword(), salt);
        user.setPassword(newPassword);
        em.persist(user);
    }

    public User getUser(int id) {
        return em.find(User.class, id);
    }

    public List<User> getUserByUsername(String username) {
        return em.createNamedQuery(User.FIND_BY_USERNAME, User.class).setParameter("username", username).getResultList();
    }

    public List<User> getUsers() {
        return em.createNamedQuery(User.FIND_ALL, User.class).getResultList();
    }
}
