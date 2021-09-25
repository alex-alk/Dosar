package com.alexandruleonte.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
@NamedQuery(name = User.FIND_BY_USERNAME, query = "select u from User u where u.userName = :userName")
@NamedQuery(name= User.FIND_ALL, query="SELECT u FROM User u")
public class User {

    public static final String FIND_BY_USERNAME = "User.findByUserName";
    public static final String FIND_ALL = "User.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_gen_user")
    @SequenceGenerator(sequenceName = "users_seq", allocationSize = 1, name = "sec_gen_user")
    private Integer id;

    @NotNull
    private String userName;

    @NotNull
    private String password;

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
