package restassured.junit;

import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Test;
import restassured.junit.specs.Specification;

import static io.restassured.RestAssured.given;
import static restassured.junit.services.Constants.*;

public class SecondTest {
    private static final ResponseSpecification RESPONSE_SPECIFICATION = Specification.responseSpecification();

    @Test
    public void openDormitories() {
        given()
                .baseUri(DORMITORIES)
                .log().method()
                .when()
                .get()
                .then()
                .spec(RESPONSE_SPECIFICATION);
    }

    @Test
    public void openFirstDormitory() {
        given()
                .baseUri(FIRST_DORMITORY)
                .log().method()
                .when()
                .get()
                .then()
                .spec(RESPONSE_SPECIFICATION);
    }
}
