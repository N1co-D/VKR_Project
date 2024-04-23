package restassured.junit;

import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Test;
import restassured.junit.specs.Specification;

import static io.restassured.RestAssured.given;
import static restassured.junit.services.Constants.*;

public class NinthTest {
    private static final ResponseSpecification RESPONSE_SPECIFICATION = Specification.responseSpecification();

    @Test
    public void openPgupsMuseum() {
        given()
                .baseUri(PGUPS_MUSEUM)
                .log().method()
                .when()
                .get()
                .then()
                .spec(RESPONSE_SPECIFICATION);
    }

    @Test
    public void pgupsMuseumZayavkaFile() {
        given()
                .baseUri(PGUPS_MUSEUM_ZAYAVKA)
                .log().method()
                .when()
                .get()
                .then()
                .spec(RESPONSE_SPECIFICATION);
    }
}
