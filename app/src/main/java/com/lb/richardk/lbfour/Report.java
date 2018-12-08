package com.lb.richardk.lbfour;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Report
{
    public String name;
    public String message;

    public Report()
    {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Report(String name, String mess)
    {
        this.name = name;
        this.message = mess;
    }
}
