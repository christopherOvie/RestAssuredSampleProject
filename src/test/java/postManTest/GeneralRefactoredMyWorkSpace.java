package postManTest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import spec.GeneralSpecificationBuider;

import static io.restassured.RestAssured.given;

public class GeneralRefactoredMyWorkSpace {

//    RequestSpecification  requestSpecification;
//    ResponseSpecification responseSpecification;
//    @BeforeClass
//    public void setUp(){
//        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
//        requestSpecBuilder.setBaseUri("https://api.getpostman.com")
//                         .addHeader("X-Api-Key","PMAK-669e05fbc34cd700015b2e98-1942493baefe5b17bfca5bdba4f153eef0")
//                         .log(LogDetail.ALL)
//                         .setContentType(ContentType.JSON);
//        requestSpecification = requestSpecBuilder.build();
//
//        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
//        responseSpecBuilder.log(LogDetail.ALL)
//                           .expectContentType(ContentType.JSON)
//                           .expectStatusCode(200);
//
//        responseSpecification=   responseSpecBuilder.build();
//  added new changes
//    }
    @Test
    public void createWorkSpaceTest(){

//payload in json
        //payload in json
        String payload= "{\n" +
                "    \"workspace\": {\n" +
                "        \"name\": \"my demo  004\",\n" +
                "        \"type\": \"personal\",\n" +
                "        \"description\": \"this is my demo as decription004\"\n" +
                "    }\n" +
                "}";

        given(GeneralSpecificationBuider.reqSpec())

               // .log().all()
                //.baseUri("https://api.getpostman.com")
                .body(payload)
               // .header("X-Api-Key","PMAK-669e05fbc34cd700015b2e98-1942493baefe5b17bfca5bdba4f153eef0")
               // .contentType(ContentType.JSON)
               // .contentType(ContentType.JSON)
             // .contentType(ContentType.JSON)
            //delete .contentType(ContentType.JSON)
            

                .when()
                .post("/workspaces")
                .then().spec(GeneralSpecificationBuider.responseSpec());
//                .log().all()
//                .assertThat().statusCode(200);
        //  id   04d6c655-1b3d-4270-87da-a25e5807a38b
    }
@Test
    public void getWorkSpaceTest() {

        String myid = "04d6c655-1b3d-4270-87da-a25e5807a38b";
        given(GeneralSpecificationBuider.reqSpec())
                //.log().all()


                //.baseUri("https://api.getpostman.com")
               // .header("X-Api-Key","PMAK-669e05fbc34cd700015b2e98-1942493baefe5b17bfca5bdba4f153eef0")
              //  .contentType(ContentType.JSON)
                .when()
                .get("/workspaces/"+myid)
                .then().spec(GeneralSpecificationBuider.responseSpec());
//                .log().all()
//                .assertThat().statusCode(200);

    }
}
