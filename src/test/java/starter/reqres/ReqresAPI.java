package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.reqres.Utils.Constant;

import java.io.File;

import static starter.reqres.Utils.Constant.BASE_URL;

public class ReqresAPI {
    public static String DELETE_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String GET_DELAYED_RESPONSE = BASE_URL+"/api/users?delay={delay}";
    public static String GET_LIST_USER = Constant.BASE_URL+"/api/users?page={page}";
    public static String GET_SINGLE_RESOURCE = Constant.BASE_URL+"/api/unknown/{id}";
    public static String GET_SINGLE_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String PATCH_UPDATE_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String POST_CREATE_USER = Constant.BASE_URL+"/api/users";
    public static String POST_LOGIN_USER = Constant.BASE_URL+"/api/login";
    public static String POST_REGISTER_USER = BASE_URL+"/api/register";
    public static String PUT_UPDATE_USER = Constant.BASE_URL+"/api/users/{id}";


    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given().pathParam("id",id);
    }

    @Step("Delete user with invalid name")
    public void deleteUser_inv(String id){
        SerenityRest.given().pathParam("id",id);
    }

    @Step("Get delayed response")
    public void getDelayedResponse(int delay){
        SerenityRest.given().pathParam("delay",delay);
    }

    @Step("Get invalid delayed response")
    public void getDelayedResponse_String(String delay){
        SerenityRest.given().pathParam("delay",delay);
    }

    @Step("Get list users")
    public void getListUsers(int page){
        SerenityRest.given().pathParam("page",page);
    }

    @Step("Get list users with String")
    public void getListUsers_String(String page){
        SerenityRest.given().pathParam("page",page);
    }

    @Step("Get single resource with id")
    public void getSingleResource(int id){
        SerenityRest.given().pathParam("id",id);
    }

    @Step("Get list users with String")
    public void getSingleResource_String(String id){
        SerenityRest.given().pathParam("id",id);
    }

    @Step("Get Single user")
    public void getSingleUserUser(int id){
        SerenityRest.given().pathParam("id",id);
    }

    @Step("Get Single user with invalid id")
    public void getInvalidUser(String id){
        SerenityRest.given().pathParam("id",id);
    }

    @Step("Patch update user")
    public void patchUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Patch update user")
    public void patchInvalidUpdateUser(String id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post create user")
    public void postCreateUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post login user")
    public void postLoginUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post register user")
    public void postRegisterUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user")
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user")
    public void putInvalidUpdateUser(String id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
}
