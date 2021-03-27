package webapi;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import webapi.models.BromaResponse;

import static io.restassured.RestAssured.given;
import static webapi.EndPoints.CHISTE_ALEATORIO_URL;

public class ChuckNorrisWebAPITests {
    @Test(priority = 0, groups = "Regression")
    public void ValidarQueElChisteTengaElNombreDeChuckNorries(){
        // Arrange
        String textoEsperado = "Chuck Norris";

        // Act
        BromaResponse respuestaChuckNorrisWebApi = given()
                .contentType(ContentType.JSON)
                .get(CHISTE_ALEATORIO_URL)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .as(BromaResponse.class);

        System.out.println(respuestaChuckNorrisWebApi.getValue());

        // Assert
        Assert.assertTrue(respuestaChuckNorrisWebApi.getValue().contains(textoEsperado));
    }
}
