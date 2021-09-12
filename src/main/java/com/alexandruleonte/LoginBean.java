package com.alexandruleonte;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginBean implements Serializable {

    private String userName;
    private String password;
    private boolean isAdmin;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String validateUserLogin() {

        String navResult = "";
        if (userName.equalsIgnoreCase("admin") && password.equals("admin")) {
            navResult = "/admin/home";
            isAdmin = true;
        } else {
            navResult = "home";
        }
        return navResult;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }
}