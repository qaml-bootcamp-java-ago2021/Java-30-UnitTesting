package unit;

import com.funkos.Funko;
import com.funkos.GestorDeFunkos;
import exceptions.FunkoNoEncontradoException;
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

    @Test
    public void GivenUnaColeccionConUnFunko_WhenLeemosUnFunko_ThenElMismoFunkoEsRetornado() throws FunkoNoEncontradoException {
        // Arrange - Preparar
        GestorDeFunkos gestorDeFunkos = new GestorDeFunkos();

        Funko funkoEsperado = new Funko();
        funkoEsperado.setId(1);
        funkoEsperado.setNombre("Pacman");

        gestorDeFunkos.agregarFunko(funkoEsperado);

        // Act - Actuar
        Funko funkoActual = gestorDeFunkos.leerFunkoPorId(funkoEsperado.getId());

        // Assert - Afirmar
        Assert.assertEquals(funkoActual, funkoEsperado, "Los Funkos no son los mismos.");
    }

    @Test
    public void GivenUnaColeccionDeFunkos_WhenActualizamosElNombreDelFunko_ThenElNombreEsActualizado(){
        // Arrange - Preparar
        GestorDeFunkos gestorDeFunkos = new GestorDeFunkos();

        Funko funko = new Funko();
        funko.setId(1);
        funko.setNombre("Pacman");

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
        GestorDeFunkos gestorDeFunkos = new GestorDeFunkos();

        Funko funko = new Funko();
        funko.setId(1);
        funko.setNombre("Pacman");

        gestorDeFunkos.agregarFunko(funko);

        // Act - Actuar
        var resultadoActual = gestorDeFunkos.borrarFunko(funko.getId());

        // Assert - Afirmar
        Assert.assertTrue(resultadoActual, "El Funko no ha sido borrado.");
    }



}
