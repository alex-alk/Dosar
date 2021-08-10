package com.alexandruleonte;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class HelloBacking {

    public String getHello() {
        return "Hello world, from JSF!";
    }

}
