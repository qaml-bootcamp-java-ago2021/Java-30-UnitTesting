package unit;

import com.funkos.Funko;
import com.funkos.GestorDeFunkos;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ClaseBaseDePruebas {
    GestorDeFunkos gestorDeFunkos;
    Funko funko;

    @BeforeMethod
    public void setup(){
        gestorDeFunkos = new GestorDeFunkos();

        funko = new Funko();
        funko.setId(1);
        funko.setNombre("Pacman");
    }

    @AfterMethod
    public void cleanup(){
        gestorDeFunkos = null;
        funko = null;
    }
}
