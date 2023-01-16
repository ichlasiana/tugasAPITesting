package starter.reqres.getDelayedResponse;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

public class GetDelayedResponse {

    @Steps
    ReqresAPI reqresAPI;
    @Given("Get delayed response with delay {int}")
    public void getDelayedResponseWithDelayDelay(int delay) {
        reqresAPI.getDelayedResponse(delay);
    }

    @When("Send request get delayed response")
    public void sendRequestGetDelayedResponse() {
        SerenityRest.when().get(ReqresAPI.GET_DELAYED_RESPONSE);
    }

    @Given("Get delayed response with String delay {string}")
    public void getDelayedResponseWithStringDelay(String delay) {
        reqresAPI.getDelayedResponse_String(delay);
    }
}
