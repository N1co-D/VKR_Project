package restassured.junit;

import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Test;
import restassured.junit.specs.Specification;

import static io.restassured.RestAssured.given;
import static restassured.junit.services.Constants.SCIENTIFIC_CONFERENCE;
import static restassured.junit.services.Constants.SCIENTIFIC_PLAN;

public class SeventhTest {
    private static final ResponseSpecification RESPONSE_SPECIFICATION = Specification.responseSpecification();

    @Test
    public void openScientificConference() {
        given()
                .baseUri(SCIENTIFIC_CONFERENCE)
                .log().method()
                .when()
                .get()
                .then()
                .spec(RESPONSE_SPECIFICATION);
    }

    @Test
    public void ScientificPlanFile() {
        given()
                .baseUri(SCIENTIFIC_PLAN)
                .log().method()
                .when()
                .get()
                .then()
                .spec(RESPONSE_SPECIFICATION);
    }
}
