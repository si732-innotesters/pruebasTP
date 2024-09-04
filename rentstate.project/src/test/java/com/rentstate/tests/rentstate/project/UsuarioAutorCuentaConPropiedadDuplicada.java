package com.rentstate.tests.rentstate.project;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioAutorCuentaConPropiedadDuplicada {
	 @Test
	    void whenUserHasDuplicateProperties_thenReturnTrue() {
	        // Arrange
	        User user = new User();
	        user.setName("John Doe");

	        List<Property> properties = new ArrayList<>();
	        properties.add(new Property("Propiedad 1", "DescripcionPrueba", "CaracteriticasPruebas", "UbicacionPrueba", new Category(), true, false, "url1", user, user, 100.0));
	        properties.add(new Property("Propiedad 1", "DescripcionPrueba", "CaracteriticasPruebas", "UbicacionPrueba", new Category(), true, false, "url2", user, user, 100.0)); 
	        properties.add(new Property("Propiedad 2", "OtraDescripcion", "OtrasCaracteriticas", "OtraUbicacion", new Category(), true, false, "url3", user, user, 100.0));

	        // Act
	        boolean result = Property.hasDuplicateProperties(user, properties);

	        // Assert
	        assertTrue(result);
	}
}

