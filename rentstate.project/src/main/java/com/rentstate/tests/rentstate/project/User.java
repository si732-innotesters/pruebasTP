// User.java
package com.rentstate.tests.rentstate.project;

import java.util.List;

public class User {
    private String name;
    private boolean isPremium;
    private double money;
    
    public User() {
    	isPremium=true;
    }

    public User(String name, boolean isPremium) {
        this.name = name;
        this.isPremium = isPremium;
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
    
    public User(String name, Boolean premium, double money) {
    	this.name = name;
    	this.isPremium = premium;
    	this.money =money;
    }

    public boolean canRentProperty(double propertyMoney) {
   
        if (this.getMoney() > propertyMoney) {
            System.out.println("El usuario cuenta con el dinero suficiente para la vivienda");
            return true;
        }
        else {
            System.out.println("El usuario no cuenta con el dinero suficiente para la vivienda, solo cuenta con" + this.getMoney() + " mientras que la vivienda cuesta: $" + propertyMoney);
            return false;
        }

    }
    
    public double descuentoPremium(double propertyPrice) {
        if (this.getIsPremium()) {
            return propertyPrice * 0.30; 
        }
        return 0;
    }

}