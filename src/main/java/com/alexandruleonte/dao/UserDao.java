package com.alexandruleonte.dao;

import com.alexandruleonte.entities.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
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

    public User getUserByUserName(String userName) {
        return em.createNamedQuery(User.FIND_BY_USERNAME, User.class).setParameter("userName", userName).getSingleResult();
    }

    public List<User> getUsers() {
        return em.createNamedQuery(User.FIND_ALL, User.class).getResultList();
    }
}
