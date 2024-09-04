// User.java
package com.rentstate.tests.rentstate.project;

import java.util.List;

public class User {
    private String name;
    private boolean isPremium;
    private double money;
    
    public User() {
    	this.name="default";
    }

    public User(String name, boolean isPremium, double money) {
        this.name = name;
        this.isPremium = isPremium;
        this.money = money; 
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsPremium() {
        return isPremium;
    }

    public void setIsPremium(boolean isPremium) {
        this.isPremium = isPremium;
    }
    public void setMoney(double money) {
    	this.money=money;
    }
    public double getMoney() {
    	return money;
    }

}
