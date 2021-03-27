package dataproviders;

import com.funkos.Funko;
import org.testng.annotations.DataProvider;

public class ProveedorDeDatos {

    @DataProvider
    public static Object[][] listaDeFunkos(){
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
}
