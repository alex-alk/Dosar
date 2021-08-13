package com.alexandruleonte;

import com.alexandruleonte.entities.Platform;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Named
@RequestScoped
public class Home {

    private static final String PERSISTENCE_UNIT_NAME = "default";

    public String getHello() throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
//        EntityManager em = factory.createEntityManager();
//
//        Platform p1 = em.find(Platform.class, 1);
//        em.close();
//        return p1.getName();

        Connection conn = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dosar", "root", "Ewsdew_01");

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }



        return "OK";
    }
}
