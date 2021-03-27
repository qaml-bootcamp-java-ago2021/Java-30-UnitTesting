package unit;

import com.funkos.Funko;
import exceptions.FunkoNoEncontradoException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GestorDeFunkosTests extends ClaseBaseDePruebas{

    @DataProvider
    protected Object[][] listaDeFunkos(){
        return new Object[][]{
                {
                    new Funko(){{
                        setId(1);
                        setNombre("Pacman");
                    }}
                },
                {
                    new Funko(){{
                        setId(2);
                        setNombre("Spiderman");
                    }}
                }
        };
    }

    //Gherkin language - Given, When, And, Then
    @Test(dataProvider = "listaDeFunkos", description = "Verificar que se pueda agregar un Funko a la coleccion")
    public void GivenUnaColeccionDeFunkos_WhenAgreagamosUnFunko_ThenTrueEsRegresado(Funko funko){
        // Arrange - Preparar

        // Act - Actuar
        boolean resultadoActual = gestorDeFunkos.agregarFunko(funko);

        // Assert - Afirmar
        Assert.assertTrue(resultadoActual);
    }

    @Test(timeOut = 500)
    public void GivenUnaColeccionConUnFunko_WhenLeemosUnFunko_ThenElMismoFunkoEsRetornado() throws FunkoNoEncontradoException {
        // Arrange - Preparar
        gestorDeFunkos.agregarFunko(funko);

        // Act - Actuar
        Funko funkoActual = gestorDeFunkos.leerFunkoPorId(funko.getId());

        // Assert - Afirmar
        Assert.assertEquals(funkoActual, funko, "Los Funkos no son los mismos.");
    }

    @Test(enabled = true)
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
