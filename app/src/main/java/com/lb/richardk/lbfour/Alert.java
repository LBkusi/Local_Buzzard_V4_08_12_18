package com.lb.richardk.lbfour;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Alert
{
    public String vehicleReg;
    // public String message;
    public String subject;
    public String uid;

    public Alert()
    {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Alert(String vReg, String sub, String uid)
    {
        this.vehicleReg = vReg;
        // this.message = mess;
        this.subject = sub;
        this.uid = uid;
    }

    public String getReg()
    {
        return vehicleReg;
    }

    public void setReg(String reg)
    {
        this.vehicleReg = reg;
    }

//    public String getMessage()
//    {
//        return message;
//    }

//    public void setMessage(String message)
//    {
//        this.message = message;
//    }

    public String getSubject()
    {
        return subject;
    }

    public void setSubject(String sub)
    {
        this.subject = sub;
    }

    public String getUid()
    {
        return uid;
    }

    public void setUid(String uid)
    {
        this.uid = uid;
    }

}