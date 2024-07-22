package spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GeneralSpecificationBuider {

    public static RequestSpecification reqSpec(){
        RequestSpecification requestSpecification;
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://api.getpostman.com")
                .addHeader("X-Api-Key","PMAK-669e05fbc34cd700015b2e98-1942493baefe5b17bfca5bdba4f153eef0")
                .log(LogDetail.ALL)
                .setContentType(ContentType.JSON);
        requestSpecification = requestSpecBuilder.build();
        return requestSpecification;
    }


    public static  ResponseSpecification responseSpec(){
        ResponseSpecification responseSpecification;
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.log(LogDetail.ALL)
                .expectContentType(ContentType.JSON)
                .expectStatusCode(200);

        responseSpecification=   responseSpecBuilder.build();
        return  responseSpecification;
    }
}
