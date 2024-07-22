package postManTest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class HashMapMyWorkSpaceTest {

    RequestSpecification  requestSpecification;
    ResponseSpecification responseSpecification;
    @BeforeClass
    public void setUp(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://api.getpostman.com")
                         .addHeader("X-Api-Key","PMAK-669e05fbc34cd700015b2e98-1942493baefe5b17bfca5bdba4f153eef0")
                         .log(LogDetail.ALL)
                         .setContentType(ContentType.JSON);
        requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.log(LogDetail.ALL)
                           .expectContentType(ContentType.JSON)
                           .expectStatusCode(200);

        responseSpecification=   responseSpecBuilder.build();

    }
    @Test
    public void createWorkSpaceTest1(){

        Map<String, String> innerHPayload=new HashMap<String,String>();

        innerHPayload.put("name","my hashmap tests");
        innerHPayload.put("type","personal");
        innerHPayload.put("description","my demo is using hashmap001");


        HashMap<String, Object> parentOuterObject= new HashMap<String, Object>();
        parentOuterObject.put("workspace",innerHPayload);

//        {
//            "workspace": {
//            "id": "66f4e622-e793-43df-b314-b1106e1656dd",
//                    "name": "my hashmap testAUTO",
//                    "description": "my demo is using hashmap",
//                    "type": "personal"
//        }
//        }



        given(requestSpecification)

                .body(parentOuterObject)


                .when()
                .post("/workspaces")
                .then().spec(responseSpecification);

        //  id   04d6c655-1b3d-4270-87da-a25e5807a38b
    }
@Test
    public void getWorkSpaceTest() {

        String myid = "04d6c655-1b3d-4270-87da-a25e5807a38b";
        given(requestSpecification)
                //.log().all()


                //.baseUri("https://api.getpostman.com")
               // .header("X-Api-Key","PMAK-669e05fbc34cd700015b2e98-1942493baefe5b17bfca5bdba4f153eef0")
              //  .contentType(ContentType.JSON)
                .when()
                .get("/workspaces/"+myid)
                .then().spec(responseSpecification);
//                .log().all()
//                .assertThat().statusCode(200);

    }
}
