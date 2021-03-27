package unit;

import com.funkos.Funko;
import com.funkos.GestorDeFunkos;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GestorDeFunkosTests {

    //Gherkin language - Given, When, And, Then
    @Test
    public void GivenUnaColeccionDeFunkos_WhenAgreagamosUnFunko_ThenTrueEsRegresado(){
        // Arrange - Preparar
        GestorDeFunkos gestorDeFunkos = new GestorDeFunkos();
        Funko funko = new Funko();
        funko.setId(1);
        funko.setNombre("Pacman");

        // Act - Actuar
        boolean resultadoActual = gestorDeFunkos.agregarFunko(funko);

        // Assert - Afirmar
        Assert.assertTrue(resultadoActual);
    }

}
