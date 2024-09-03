// Property.java
package com.rentstate.tests.rentstate.project;

import java.util.ArrayList;
import java.util.List;

public class Property {

    private Long Id;
    private String name;
    private String description;
    private String characteristics;
    private String location;
    private Category category;
    private Boolean available = true;
    private Boolean isPosted = false;
    private String urlImg;
    private User renter;
    private User author;
    private List<User> reservedByUsers = new ArrayList<>();
    private double price;

    public Property() {
    }

    public Property(String name, String description, String characteristics, String location, Category category, Boolean available, Boolean isPosted, String urlImg, User renter, User author, double price) {
        this.name = name;
        this.description = description;
        this.characteristics = characteristics;
        this.location = location;
        this.category = category;
        this.available = available;
        this.isPosted = isPosted;
        this.urlImg = urlImg;
        this.renter = renter;
        this.author = author;
        this.price = price;
    }

    public boolean checkRentStatus(boolean isPosted, boolean isAvailable) {
        if (isPosted && isAvailable) {
            System.out.println("La propiedad puede ser rentada");
            return true;
        } else if (isPosted && !isAvailable) {
            System.out.println("La propiedad no puede ser rentada porque alguien mas ya la está ocupando.");
            return false;
        } else {
            System.out.println("La propiedad no está publicada.");
            return false;
        }
    }

    public void setPostedStatus(boolean isPosted) {
        this.isPosted = isPosted;
    }

    public void setAvailableStatus(boolean isAvailable) {
        this.available = isAvailable;
    }

    public Boolean getIsPosted() {
        return isPosted;
    }

    public Boolean getAvailable() {
        return available;
    }
    
   

    public static boolean hasMoreThanThreeProperties(User user, List<Property> properties) {
        int count = 0;
        for (Property property : properties) {
            if (property.getAuthor().equals(user)) {
                count++;
            }
        }
        if (count > 3) {
            System.out.println("Revisar al usuario: " + user.getName());
            return true;
        }
        return false;
    }

   
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public User getAuthor() {
        return author;
    }

    public User getRenter() {
        return renter;
    }
    
    public void setAuthor(User author) {
    	this.author=author;
    }
    public void setRenter(User renter) {
    	this.renter=renter;
    }
    public void applyDiscountToProperty() {
        if (renter.getIsPremium()) {
            double discount = this.price * 0.30; 
            this.price -= discount;
            System.out.println("Se ha aplicado un descuento a la propiedad. Nuevo precio: " + this.price);
        }
    }
    public boolean rentProperty() {
        if (checkRentStatus(this.isPosted, this.available)) { // Verifica si la propiedad está publicada y disponible
            if (renter.canRentProperty(this.price)) { // Verifica si el inquilino tiene suficiente dinero
                if (renter.getIsPremium()) {
                    this.applyDiscountToProperty(); // Aplica el descuento si el inquilino es premium
                }
                return true;
            }
        }
        return false;
    }



   
}