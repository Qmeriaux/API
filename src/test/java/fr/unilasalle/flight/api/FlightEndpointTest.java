package fr.unilasalle.flight.api;

import io.quarkus.test.junit.QuarkusTest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

@QuarkusTest
public class FlightEndpointTest {

    @Test
    public void testFlightsEndpoint() {
        // Assurez-vous que votre API est en cours d'exécution
        RestAssured.baseURI = "http://localhost:8080";

        given()
                .when().get("/flights")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(2)); // Par exemple, vérifiez que la liste a au moins 2 vols.
    }

    // Ajoutez d'autres méthodes de test ici
}
