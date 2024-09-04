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
    
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public static boolean hasDuplicateProperties(User user, List<Property> properties) {
        for (int i = 0; i < properties.size(); i++) {
            Property property1 = properties.get(i);
            if (property1.getAuthor().equals(user)) {
                for (int j = i + 1; j < properties.size(); j++) {
                    Property property2 = properties.get(j);
                    if (property2.getAuthor().equals(user) &&
                        property1.getName().equals(property2.getName()) &&
                        property1.getDescription().equals(property2.getDescription()) &&
                        property1.getLocation().equals(property2.getLocation())) {
                        System.out.println("Revisar al usuario autor: " + user.getName());
                        return true;  
                    }
                }
            }
        }
        return false;  
    }
    
    public static boolean renterHasFundsForPropertyRent(User renter, Property property) {
        double propertyPrice = property.getPrice();
        double discountFactor = 1;
        
        if (renter.getIsPremium()) {
        	discountFactor = 0.70;
        }
        System.out.println(discountFactor);
        double finalPrice = propertyPrice * discountFactor;

        System.out.println(finalPrice);
        if (renter.getMoney() >= finalPrice) {
            System.out.println(renter.getName() + " tiene suficiente dinero para alquilar la propiedad.");
            return true;
        } else {
            System.out.println(renter.getName() + " no tiene suficiente dinero para alquilar la propiedad.");
            return false;
        }
    }

    
   
    public boolean rentProperty(User newRenter,boolean availableProperty) {
        if (!availableProperty) {
            System.out.println("No se puede alquilar la propiedad porque no está disponible para alquilar.");
            return false;
        }

        if (!hasSufficientFunds(newRenter)) {
            System.out.println("El inquilino no tiene fondos suficientes para alquilar la propiedad.");
            return false;
        }

        this.renter = newRenter;
        this.available = false;
        System.out.println("La propiedad ha sido alquilada a " + newRenter.getName() + ".");
        return true;
    }

    public boolean canRentProperty() {
        return checkRentStatus(this.isPosted, this.available);
    }

    private boolean hasSufficientFunds(User renter) {
        return renterHasFundsForPropertyRent(renter, this);
    }
    
    public void setAvailable(boolean available) {
    	this.available=available;
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
  
}
