package postManTest;

import api.Workspace1;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import spec.GeneralSpecificationBuider;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class GeneralRefactoredMyWorkSpaceHashMap {


    @Test
    public void createWorkSpaceTest(){

        Map<String, String> innerHPayload=new HashMap<String,String>();
        innerHPayload.put("name","my hashmap tests011");
        innerHPayload.put("type","personal");
        innerHPayload.put("description","my demo is using hashmap33");


        HashMap<String, Object> parentOuterObject= new HashMap<String, Object>();
        parentOuterObject.put("workspace",innerHPayload);

    Response respone=    Workspace1.createNewWorkspace(parentOuterObject);;
//        given(GeneralSpecificationBuider.reqSpec())
//
//                .body(parentOuterObject)
//
//                .when()
//                .post("/workspaces")
//                .then().spec(GeneralSpecificationBuider.responseSpec());
    }
@Test
    public void getWorkSpaceTest() {

        String myid = "04d6c655-1b3d-4270-87da-a25e5807a38b";
    Response response= Workspace1.getNewWorkspace(myid);
  String workspaceName=  response.path("workspace.name");
    String workspaceDescription=  response.path("workspace.description");

    assertThat(workspaceName,equalTo("my demo  workspace"));

   assertThat(workspaceDescription,equalTo("this is my demo as decription"));


//        given(GeneralSpecificationBuider.reqSpec())
//
//         .when()
//                .get("/workspaces/"+myid)
//         .then().spec(GeneralSpecificationBuider.responseSpec());


    }
}
