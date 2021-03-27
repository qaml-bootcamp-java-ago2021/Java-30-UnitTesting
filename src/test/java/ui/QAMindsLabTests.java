package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class QAMindsLabTests {
    WebDriver driver;

    @BeforeClass
    public void classInitialize(){
        driver = new FirefoxDriver();
    }

    @AfterClass(alwaysRun = true)
    public void classCleanup(){
        driver.close();
    }

    @Test
    public void ValidarQueElTituloDeQAMindsLabEsCorrecto(){
        // Arrange
        String tituloEsperado = "QA Minds Lab";
        driver.get("http://qamindslab.com/");

        // Act
        var tituloActual = driver.getTitle();

        // Assert
        Assert.assertEquals(tituloActual, tituloEsperado, "El título de la página no es correcto.");
    }

    @Test
    public void ValidarQueElLogDeQAMindsEstaDesplegado(){
        // Arrange
        driver.get("http://qamindslab.com/");

        WebElement elemento = driver.findElement(By.xpath("*//a/img[contains(@alt, 'logo')]"));

        // Act
        var logoDesplegado = elemento.isDisplayed();

        // Assert
        Assert.assertTrue(logoDesplegado, "El logo de QA Minds no se está mostrando.");
    }
}
