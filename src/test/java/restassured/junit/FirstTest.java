package restassured.junit;

import io.restassured.specification.ResponseSpecification;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import restassured.junit.specs.Specification;

import static io.restassured.RestAssured.given;
import static restassured.junit.services.Constants.*;

@Slf4j
public class FirstTest {
    private static final ResponseSpecification RESPONSE_SPECIFICATION = Specification.responseSpecification();

    @Test
    public void openSchedule() {
        given()
                .baseUri(SCHEDULE_PAGE)
                .log().method()
                .when()
                .get()
                .then()
                .spec(RESPONSE_SPECIFICATION);
    }

    @Test
    public void searchByGroup() {
        given()
                .baseUri(GROUP_SEARCH)
                .log().method()
                .queryParam("group", 310)
                .when()
                .get()
                .then()
                .spec(RESPONSE_SPECIFICATION);
    }

    @Test
    public void openGroupSchedule() {
        given()
                .baseUri(ISM310_SCHEDULE)
                .log().method()
                .when()
                .get()
                .then()
                .spec(RESPONSE_SPECIFICATION);
    }
}