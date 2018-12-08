package com.lb.richardk.lbfour;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Enquiry
{
    public String email;
    public String subject;
    public String message;

    public Enquiry()
    {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Enquiry(String em, String sub, String mess)
    {
        this.email = em;
        this.subject = sub;
        this.message = mess;
    }
}