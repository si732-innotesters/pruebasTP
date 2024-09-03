package com.rentstate.tests.rentstate.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DisponibleParaRentaPruebaUnitaria {
    @Test
    void whenPropertyIsPostedAndNotAvailable_thenCannotBeRented() {
        // Arrange
        Property property = new Property();
        property.setPostedStatus(true);
        property.setAvailableStatus(false);

        // Act
        boolean isPosted = property.getIsPosted();
        boolean isAvailable = property.getAvailable();
        boolean result = property.checkRentStatus(isPosted, isAvailable);

        // Assert
        assertFalse(result, "La propiedad no puede ser rentada porque alguien mas ya la está ocupando.");
    }
}