package starter.reqres.postCreateUser;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.Constant;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class CreateUserStepdefs {

    @Steps
    ReqresAPI reqresAPI;
    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File valid_json = new File(Constant.JSON_REQUEST+"/CreateUser/RequestUser.json");
        reqresAPI.postCreateUser(valid_json);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @Then("Should return status code {int}")
    public void shouldReturnStatusCode(int status_code) {
        SerenityRest.then().statusCode(status_code);
    }

    @And("Response body name should be {string} and job {string}")
    public void responseBodyNameShouldBeAndJob(String name, String job) {
        SerenityRest.then()
                .body("name", equalTo(name))
                .body("job",equalTo(job));
    }

    @Given("Post create user with valid json \\(contain special character)")
    public void postCreateUserWithValidJsonContainSpecialCharacter() {
        File specChar_json = new File(Constant.JSON_REQUEST+"/CreateUser/RequestUser_specChar.json");
        reqresAPI.postCreateUser(specChar_json);
    }

    @Given("Post create user with valid json \\(contain numeric)")
    public void postCreateUserWithValidJsonContainNumeric() {
        File numChar_json = new File(Constant.JSON_REQUEST+"/CreateUser/RequestUser_numChar.json");
        reqresAPI.postCreateUser(numChar_json);
    }

    @Given("Post create user with invalid json")
    public void postCreateUserWithInvalidJson() {
        File inv_json = new File(Constant.JSON_REQUEST+"/CreateUser/RequestUser_inv.json");
        reqresAPI.postCreateUser(inv_json);
    }

    @Given("Post create user with no content json")
    public void postCreateUserWithNoContentJson() {
        File null_json = new File(Constant.JSON_REQUEST+"/CreateUser/RequestUser_null.json");
        reqresAPI.postCreateUser(null_json);
    }
}
