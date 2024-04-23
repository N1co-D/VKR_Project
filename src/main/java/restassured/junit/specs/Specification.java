package restassured.junit.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.ResponseSpecification;

public class Specification {

    public static ResponseSpecification responseSpecification() {
        return new ResponseSpecBuilder()
                .log(LogDetail.STATUS)
                .expectStatusCode(200)
                .build();
    }
}