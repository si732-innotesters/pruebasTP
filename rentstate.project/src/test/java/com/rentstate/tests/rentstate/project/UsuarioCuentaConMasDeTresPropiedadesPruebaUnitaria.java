package com.rentstate.tests.rentstate.project;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioCuentaConMasDeTresPropiedadesPruebaUnitaria {
    @Test
    void whenUserHasMoreThanThreeProperties_thenReturnReviewMessage() {
        // Arrange
        User user = new User();
        user.setName("John Doe");

        List<Property> properties = new ArrayList<>();
        properties.add(new Property("Propiedad 1", "DescripcionPrueba", "CaracteriticasPruebas", "UbicacionPrueba", new Category(), true, false, "url1", user, user, 100.0));
        properties.add(new Property("Propiedad 2", "DescripcionPrueba", "CaracteriticasPruebas", "UbicacionPrueba", new Category(), true, false, "url2", user, user, 100.0));
        properties.add(new Property("Propiedad 3", "DescripcionPrueba", "CaracteriticasPruebas", "UbicacionPrueba", new Category(), true, false, "url3", user, user, 100.0));
        properties.add(new Property("Propiedad 4", "DescripcionPrueba", "CaracteriticasPruebas", "UbicacionPrueba", new Category(), true, false, "url4", user, user, 100.0));

        // Act
        boolean result = Property.hasMoreThanThreeProperties(user, properties);

        // Assert
        assertTrue(result);
    }
}
