package starter.reqres.getSingleResource;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.Constant;

import java.io.File;

public class GetSingleResourceStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get single resource with id {int}")
    public void getSingleResourceWithIdId(int id) {
        reqresAPI.getSingleResource(id);
    }

    @When("Send request get single resource")
    public void sendRequestGetSingleResource() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_RESOURCE);
    }

    @And("Validate json schema single resource")
    public void validateJsonSchemaSingleResource() {
        File jsonSchemaSingle = new File(Constant.JSON_SCHEMA+"/SingleResourceSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaSingle));
    }

    @Given("Get single resource with invalid id {string}")
    public void getSingleResourceWithInvalidId(String id) {
        reqresAPI.getSingleResource_String(id);
    }
}
