package com.alexandruleonte.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
@NamedQuery(name = User.FIND_BY_USERNAME, query = "select u from User u where u.username = :username")
@NamedQuery(name= User.FIND_ALL, query="SELECT u FROM User u")
public class User {

    public static final String FIND_BY_USERNAME = "User.findByUsername";
    public static final String FIND_ALL = "User.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Username is required")
    @Column(length = 100)
    private String username;

    @NotBlank(message = "Password is required")
    @Column(length = 100)
    private String password;

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
