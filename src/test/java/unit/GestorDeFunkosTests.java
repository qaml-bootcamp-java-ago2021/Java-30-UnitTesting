package unit;

import com.funkos.Funko;
import com.funkos.GestorDeFunkos;
import exceptions.FunkoNoEncontradoException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GestorDeFunkosTests extends ClaseBaseDePruebas{

    //Gherkin language - Given, When, And, Then
    @Test
    public void GivenUnaColeccionDeFunkos_WhenAgreagamosUnFunko_ThenTrueEsRegresado(){
        // Arrange - Preparar

        // Act - Actuar
        boolean resultadoActual = gestorDeFunkos.agregarFunko(funko);

        // Assert - Afirmar
        Assert.assertTrue(resultadoActual);
    }

    @Test
    public void GivenUnaColeccionConUnFunko_WhenLeemosUnFunko_ThenElMismoFunkoEsRetornado() throws FunkoNoEncontradoException {
        // Arrange - Preparar
        gestorDeFunkos.agregarFunko(funko);

        // Act - Actuar
        Funko funkoActual = gestorDeFunkos.leerFunkoPorId(funko.getId());

        // Assert - Afirmar
        Assert.assertEquals(funkoActual, funko, "Los Funkos no son los mismos.");
    }

    @Test
    public void GivenUnaColeccionDeFunkos_WhenActualizamosElNombreDelFunko_ThenElNombreEsActualizado(){
        // Arrange - Preparar
        gestorDeFunkos.agregarFunko(funko);
        String nombreEsperado = "Batman";

        // Act - Actuar
        funko.setNombre(nombreEsperado);
        gestorDeFunkos.actualizarNombreFunko(funko);

        // Assert - Afirmar
        Assert.assertEquals(nombreEsperado, funko.getNombre(), "Los Nombres de los Funkos no son los mismos.");
    }

    @Test
    public void GivenUnaColeecionDeFunkos_WhenSeBorraUnFunko_ThenElFunkoEsBorrado(){
        // Arrange - Preparar
        gestorDeFunkos.agregarFunko(funko);

        // Act - Actuar
        var resultadoActual = gestorDeFunkos.borrarFunko(funko.getId());

        // Assert - Afirmar
        Assert.assertTrue(resultadoActual, "El Funko no ha sido borrado.");
    }

    @Test(expectedExceptions = FunkoNoEncontradoException.class)
    public void GivenUnaColeccionDeFunkos_CuandoBuscamosUnIdInexistente_ThenUnaExcepcionEsArrojada() throws FunkoNoEncontradoException {
        // Arrange - Preparar

        // Act - Actuar
        gestorDeFunkos.leerFunkoPorId(3);
    }



}
