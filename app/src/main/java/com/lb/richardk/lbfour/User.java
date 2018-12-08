package com.lb.richardk.lbfour;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {

    public String number;
    public String email;
    //public String borough;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String num, String em) {
        this.number = num;
        this.email = em;
        //this.borough = bor;
    }

}
