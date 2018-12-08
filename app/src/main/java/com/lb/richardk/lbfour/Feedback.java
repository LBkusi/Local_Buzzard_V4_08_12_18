package com.lb.richardk.lbfour;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Feedback
{
    public float rating;
    public String message;

    public Feedback()
    {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Feedback(float rat, String mess)
    {
        this.rating = rat;
        this.message = mess;
    }
}