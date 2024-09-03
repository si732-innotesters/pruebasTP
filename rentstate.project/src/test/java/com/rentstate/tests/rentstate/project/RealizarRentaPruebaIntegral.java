package com.rentstate.tests.rentstate.project;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;


import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RealizarRentaPruebaIntegral {
	
	@Mock User renter;
	@Mock User author;
	@InjectMocks Property property = new Property("Propiedad 1", 
			"DescripcionPrueba",
			"CaracteriticasPruebas", 
			"UbicacionPrueba",
			new Category(), true, false, "url1", renter, author, 100.0);
	
    @Test
    void puedeRentarConDineroUsuarioYPropiedad() {
        
    }
}
