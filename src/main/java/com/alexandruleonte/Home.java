package com.alexandruleonte;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Home {

    public String getHello() {
        return "Hello world, from JSF!";
    }

}