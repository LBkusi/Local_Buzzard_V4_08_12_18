package com.lb.richardk.lbfour;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class UserCar
{

    public String vehicleReg;
    public String colour;
    public String make;
    public String model;
    public String borough;

    public UserCar() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public UserCar(String vReg, String col, String make, String mod, String bor) {
        this.vehicleReg = vReg;
        this.colour = col;
        this.make = make;
        this.model = mod;
        this.borough = bor;
    }

    public String getBorough() {
        return borough;
    }

    public void setBorough(String bor) {
        this.borough = bor;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String col) {
        this.colour = col;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String mod) {
        this.model = mod;
    }

    public String getVehicleReg() {
        return vehicleReg;
    }

    public void setVehicleReg(String vReg) {
        this.vehicleReg = vReg;
    }

}