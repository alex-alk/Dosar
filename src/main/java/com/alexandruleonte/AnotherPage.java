package com.alexandruleonte;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class AnotherPage {

    public String getHello() {
        return "Another Page!";
    }

}
