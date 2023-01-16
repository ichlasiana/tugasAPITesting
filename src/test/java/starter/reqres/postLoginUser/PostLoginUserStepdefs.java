package starter.reqres.postLoginUser;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.Constant;

import java.io.File;

public class PostLoginUserStepdefs {

    @Steps
    ReqresAPI reqresAPI;
    @Given("Post login user with valid json")
    public void postLoginUserWithValidJson() {
        File json = new File(Constant.JSON_REQUEST+"/RegisterUser.json");
        reqresAPI.postLoginUser(json);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN_USER);
    }

    @Given("Post login user with invalid json")
    public void postLoginUserWithInvalidJson() {
        File inv_json = new File(Constant.JSON_REQUEST+"/RegisterUser_Invalid.json");
        reqresAPI.postLoginUser(inv_json);
    }

    @Given("Post login user with invalid email")
    public void postLoginUserWithInvalidEmail() {
        File inv_email_json = new File(Constant.JSON_REQUEST+"/RegisterUser_InvUser.json");
        reqresAPI.postLoginUser(inv_email_json);
    }

    @Given("Post login user with only email")
    public void postLoginUserWithOnlyEmail() {
        File email_json = new File(Constant.JSON_REQUEST+"/RegisterUser_Email.json");
        reqresAPI.postLoginUser(email_json);
    }

    @Given("Post login user with invalid account")
    public void postLoginUserWithInvalidAccount() {
        File inv_acc_json = new File(Constant.JSON_REQUEST+"/RegisterUser_WrongData.json");
        reqresAPI.postLoginUser(inv_acc_json);
    }

    @Given("Post login user with only password")
    public void postLoginUserWithOnlyPassword() {
        File pwd_json = new File(Constant.JSON_REQUEST+"/RegisterUser_Pwd.json");
        reqresAPI.postLoginUser(pwd_json);
    }
}
