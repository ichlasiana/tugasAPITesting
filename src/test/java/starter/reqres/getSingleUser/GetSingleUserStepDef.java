package starter.reqres.getSingleUser;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.Constant;

import java.io.File;

public class GetSingleUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get single user with id {int}")
    public void getSingleUserWithIdId(int id) {
        reqresAPI.getSingleUserUser(id);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }


    @And("Validate json schema single user")
    public void validateJsonSchemaListUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/SingleUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get single user with invalid id {string}")
    public void getSingleUserWithInvalidId(String id) {
        reqresAPI.getInvalidUser(id);
    }
}
