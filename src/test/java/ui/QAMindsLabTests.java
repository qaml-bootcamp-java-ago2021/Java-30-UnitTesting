package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;

public class QAMindsLabTests {
    WebDriver driver;

    @BeforeClass
    public void classInitialize() throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "/home/marcodejesus/IdeaProjects/BPA-Agosto2021/Java-30-UnitTesting/src/main/resources/geckodriver");

        File file = new File("/home/marcodejesus/IdeaProjects/BPA-Agosto2021/Java-30-UnitTesting/src/main/resources/geckodriver");
        FirefoxBinary firefoxBinary = new FirefoxBinary(file);
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);

        driver = new FirefoxDriver();
    }

    @AfterClass(alwaysRun = true)
    public void classCleanup(){
        driver.close();
    }

    @Test
    public void ValidarQueElTituloDeQAMindsLabEsCorrecto() throws InterruptedException {
        Thread.sleep(3000);

        // Arrange
        String tituloEsperado = "QA Minds Lab";
        driver.get("http://qamindslab.com/");

        // Act
        var tituloActual = driver.getTitle();

        // Assert
        Assert.assertEquals(tituloActual, tituloEsperado, "El título de la página no es correcto.");
    }

    @Test
    public void ValidarQueElLogDeQAMindsEstaDesplegado() throws InterruptedException {
        Thread.sleep(3000);

        // Arrange
        driver.get("http://qamindslab.com/");

        WebElement elemento = driver.findElement(By.xpath("*//a/img[contains(@alt, 'logo')]"));

        // Act
        var logoDesplegado = elemento.isDisplayed();

        // Assert
        Assert.assertTrue(logoDesplegado, "El logo de QA Minds no se está mostrando.");
    }
}
