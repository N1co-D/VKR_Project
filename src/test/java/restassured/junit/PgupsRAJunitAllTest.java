package restassured.junit;

import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Test;
import restassured.junit.specs.Specification;

import static io.restassured.RestAssured.given;
import static restassured.junit.services.Constants.*;

public class PgupsRAJunitAllTest {
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

    @Test
    public void openPriemPgups() {
        given()
                .baseUri(PRIEM_PGUPS)
                .log().method()
                .when()
                .get()
                .then()
                .spec(RESPONSE_SPECIFICATION);
    }

    @Test
    public void openPriemPlan() {
        given()
                .baseUri(PRIEM_PLAN)
                .log().method()
                .when()
                .get()
                .then()
                .spec(RESPONSE_SPECIFICATION);
    }

    @Test
    public void priemPlan2024file() {
        given()
                .baseUri(PRIEM_PLAN_2024)
                .log().method()
                .when()
                .get()
                .then()
                .spec(RESPONSE_SPECIFICATION);
    }

    @Test
    public void openEducation() {
        given()
                .baseUri(EDUCATION)
                .log().method()
                .when()
                .get()
                .then()
                .spec(RESPONSE_SPECIFICATION);
    }

    @Test
    public void ismPlanFile() {
        given()
                .baseUri(ISM_PLAN)
                .log().method()
                .when()
                .get()
                .then()
                .spec(RESPONSE_SPECIFICATION);
    }

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

    @Test
    public void openPrioritet2030() {
        given()
                .baseUri(PRIORITET)
                .log().method()
                .when()
                .get()
                .then()
                .spec(RESPONSE_SPECIFICATION);
    }

    @Test
    public void openDigitalDepartament() {
        given()
                .baseUri(DIGITAL_DEPARTAMWNT)
                .log().method()
                .when()
                .get()
                .then()
                .spec(RESPONSE_SPECIFICATION);
    }

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

    @Test
    public void openMagistracySection() {
        given()
                .baseUri(PRIEM_MAGISTRACY)
                .log().method()
                .when()
                .get()
                .then()
                .spec(RESPONSE_SPECIFICATION);
    }

    @Test
    public void MagistracyEducationCostFile() {
        given()
                .baseUri(PRIEM_MAGISTRACY_COST)
                .log().method()
                .when()
                .get()
                .then()
                .spec(RESPONSE_SPECIFICATION);
    }

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

    @Test
    public void openPish() {
        given()
                .baseUri(PISH)
                .log().method()
                .when()
                .get()
                .then()
                .spec(RESPONSE_SPECIFICATION);
    }

    @Test
    public void openPishAsProgram() {
        given()
                .baseUri(PISH_AS_PROGRAM)
                .log().method()
                .when()
                .get()
                .then()
                .spec(RESPONSE_SPECIFICATION);
    }
}