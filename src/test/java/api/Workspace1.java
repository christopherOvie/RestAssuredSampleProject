package api;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import spec.GeneralSpecificationBuider;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Workspace1 {

    @Test
    public static Response createNewWorkspace(HashMap<String, Object> payload) {
        Response response = given(GeneralSpecificationBuider.reqSpec())

                .body(payload)

                .when()
                .post("/workspaces")
                .then().spec(GeneralSpecificationBuider.responseSpec()).extract().response();
        return response;
    }


@Test
    public static Response getNewWorkspace(String wsID){

           return given(GeneralSpecificationBuider.reqSpec())
              .when().get("/workspaces/"+wsID)
              .then().spec(GeneralSpecificationBuider.responseSpec()).extract().response();
    }
}
