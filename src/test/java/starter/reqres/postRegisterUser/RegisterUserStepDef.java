package starter.reqres.postRegisterUser;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.Constant;

import java.io.File;

public class RegisterUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Post register user with valid json")
    public void postRegisterUserWithValidJson() {
        File validJson = new File(Constant.JSON_REQUEST+"/RegisterUser/RegisterUser.json");
        reqresAPI.postRegisterUser(validJson);
    }

    @When("Send request post register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_USER);
    }

    @And("Validate showing id and token as json schema register user")
    public void validateShowingIdAndTokenAsJsonSchemaRegisterUser() {
        File successJsonSchema = new File(Constant.JSON_SCHEMA+"/ValidRegister_Schema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(successJsonSchema));
    }

    @Given("Post register user with invalid json")
    public void postRegisterUserWithInvalidJson() {
        File invalidJson = new File(Constant.JSON_REQUEST+"/RegisterUser/RegisterUser_Invalid.json");
        reqresAPI.postRegisterUser(invalidJson);
    }

    @And("Validate showing error message as json schema register user")
    public void validateShowingErrorMessageAsJsonSchemaRegisterUser() {
        File errorJsonSchema = new File(Constant.JSON_SCHEMA+"/ErrorRegister_Schema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(errorJsonSchema));
    }

    @Given("Post register user with different email and password")
    public void postRegisterUserWithInvalidEmail() {
        File invalidEmailJson = new File(Constant.JSON_REQUEST+"/RegisterUser/RegisterUser_InvUser.json");
        reqresAPI.postRegisterUser(invalidEmailJson);
    }

    @Given("Post register user with only email")
    public void postRegisterUserWithOnlyEmail() {
        File emailJson = new File(Constant.JSON_REQUEST+"/RegisterUser/RegisterUser_Email.json");
        reqresAPI.postRegisterUser(emailJson);
    }

    @Given("Post register user with only password")
    public void postRegisterUserWithOnlyPassword() {
        File pwdJson = new File(Constant.JSON_REQUEST+"/RegisterUser/RegisterUser_Pwd.json");
        reqresAPI.postRegisterUser(pwdJson);
    }

    @Given("Post register user with invalid data")
    public void postRegisterUserWithInvalidData() {
        File invalidDataJson = new File(Constant.JSON_REQUEST+"/RegisterUser/RegisterUser_WrongData.json");
        reqresAPI.postRegisterUser(invalidDataJson);
    }

}
