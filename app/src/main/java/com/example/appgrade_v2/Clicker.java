package com.example.appgrade_v2;

import java.io.Serializable;

public class Clicker implements Serializable {

    public String subject;
    public String gradelvl;

    public Clicker(){

    }

    public Clicker(String subject, String gradelvl) {
        this.subject = subject;
        this.gradelvl = gradelvl;

    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGradelvl() {
        return gradelvl;
    }

    public void setGradelvl(String gradelvl) {
        this.gradelvl = gradelvl;
    }

}
