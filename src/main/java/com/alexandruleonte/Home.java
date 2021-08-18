package com.alexandruleonte;

import com.alexandruleonte.entities.Platform;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.*;

@Named
@RequestScoped
public class Home {

//    @PersistenceContext(unitName = "default")
//    EntityManager em;

    public String getHello() {
//        Platform p1 = em.find(Platform.class, 1);
//        return p1.getName();
        return "OK";
    }
}
