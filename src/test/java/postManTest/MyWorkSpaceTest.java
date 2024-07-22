package postManTest;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class MyWorkSpaceTest {

    @Test
    public void createWorkSpaceTest(){


        String payload= "{\n" +
                "    \"workspace\": {\n" +
                "        \"name\": \"my demo  workspace\",\n" +
                "        \"type\": \"personal\",\n" +
                "        \"description\": \"this is my demo as decription\"\n" +
                "    }\n" +
                "}";

        given().log().all()


                .baseUri("https://api.getpostman.com")
                .body(payload)
                .header("X-Api-Key","PMAK-669e05fbc34cd700015b2e98-1942493baefe5b17bfca5bdba4f153eef0")
                .contentType(ContentType.JSON)

                .when()
                .post("/workspaces")
                .then().log().all()
                .assertThat().statusCode(200);
        //  id   04d6c655-1b3d-4270-87da-a25e5807a38b
    }
@Test
    public void getWorkSpaceTest() {

        String myid = "04d6c655-1b3d-4270-87da-a25e5807a38b";
        given().log().all()


                .baseUri("https://api.getpostman.com")
                .header("X-Api-Key","PMAK-669e05fbc34cd700015b2e98-1942493baefe5b17bfca5bdba4f153eef0")
                .contentType(ContentType.JSON)
                .when()
                .get("/workspaces/"+myid)
                .then().log().all()
                .assertThat().statusCode(200);

    }
}
