package restassured.junit;

import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Test;
import restassured.junit.specs.Specification;

import static io.restassured.RestAssured.given;
import static restassured.junit.services.Constants.*;

public class FifthTest {
    private static final ResponseSpecification RESPONSE_SPECIFICATION = Specification.responseSpecification();

    @Test
    public void openFacultyContacts() {
        given()
                .baseUri(FACULTY_CONTACTS)
                .log().method()
                .when()
                .get()
                .then()
                .spec(RESPONSE_SPECIFICATION);
    }

    @Test
    public void openAitFaculty() {
        given()
                .baseUri(AIT_FACULTY)
                .log().method()
                .when()
                .get()
                .then()
                .spec(RESPONSE_SPECIFICATION);
    }
}
