package com.rentstate.tests.rentstate.project;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class RealizarRentaPruebaIntegral {

    @Mock
    User renter;

    @Mock
    User author;

    @InjectMocks
    Property property = new Property(
            "Departamento en el centro", 
            "Departamento de 2 habitaciones", 
            "2 habitaciones, 1 baño", 
            "Centro", 
            new Category(), 
            true, 
            true, 
            "url-imagen", 
            null, 
            author, 
            100.0 
        );

    @Test
    void puedeRentarConDineroUsuarioYPropiedad() {
        Mockito.when(renter.getName()).thenReturn("Roberto");
        Mockito.when(renter.getMoney()).thenReturn(70.0); 
        Mockito.when(renter.getIsPremium()).thenReturn(true); 

        boolean rentStatus = property.checkRentStatus(property.getIsPosted(), property.getAvailable());
        assertTrue(rentStatus);

        boolean fundsCheck = Property.renterHasFundsForPropertyRent(renter, property);
        assertTrue(fundsCheck);

        boolean result = property.rentProperty(renter, property.getAvailable());

        assertTrue(result);

        assertEquals(renter, property.getRenter());
    }
}
