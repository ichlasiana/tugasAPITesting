package starter.reqres.getListUsers;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.ReqresResponses;

import static org.hamcrest.Matchers.equalTo;

public class GetListUserStepDef {

    @Steps
    ReqresAPI reqresAPI;
    @Given("Get list user with page {int}")
    public void getListUserWithPagePage(int page) {
        reqresAPI.getListUsers(page);
    }

    @When("Send request get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USER);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBePage(int page) {
        SerenityRest.then()
                .body(ReqresResponses.PAGE, equalTo(page));
    }

    @Given("Get list user with page {string}")
    public void getListUserWithPage(String page) {
            reqresAPI.getListUsers_String(page);
    }

    @And("Response body page should be {string}")
    public void responseBodyPageShouldBe(String page) {
        SerenityRest.then().body(ReqresResponses.PAGE, equalTo(page));
    }
}
