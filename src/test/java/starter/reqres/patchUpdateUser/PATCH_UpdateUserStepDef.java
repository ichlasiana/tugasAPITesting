package starter.reqres.patchUpdateUser;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.Constant;
import starter.reqres.Utils.ReqresResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PATCH_UpdateUserStepDef {

    @Steps
    ReqresAPI reqresAPI;
    @Given("Patch update user with valid json with id {int}")
    public void patchUpdateUserWithValidJsonWithId(int id) {
        File jsonValid = new File(Constant.JSON_REQUEST+"/UpdateUser/UpdateUser.json");
        reqresAPI.patchUpdateUser(id,jsonValid);
    }

    @When("Send request patch update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().patch(ReqresAPI.PATCH_UPDATE_USER);
    }

    @And("Validate json schema patch update user")
    public void validateJsonSchemaUpdateUser_PATCH() {
        File validJsonSchema = new File(Constant.JSON_SCHEMA+"/UpdateUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(validJsonSchema));
    }

    @Given("Patch update user with valid json that contain more variable with id {int}")
    public void patchUpdateUserWithValidJsonThatContainMoreVariableWithId(int id) {
        File morevar_json = new File(Constant.JSON_REQUEST+"/UpdateUser/UpdateUser_moreVar.json");
        reqresAPI.patchUpdateUser(id,morevar_json);
    }

    @And("Validate json schema update user with more variable using PATCH")
    public void validateJsonSchemaUpdateUserWithMoreVariable_PATCH() {
        File moreVar_jsonSchema = new File(Constant.JSON_SCHEMA+"/UpdateUserMoreVar_Schema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(moreVar_jsonSchema));
    }

    @Given("Patch update user with invalid json with id {int}")
    public void patchUpdateUserWithInvalidJsonWithId(int id) {
        File invjson = new File(Constant.JSON_REQUEST+"/UpdateUser/UpdateUser_Invld.json");
        reqresAPI.patchUpdateUser(id,invjson);
    }

    @Given("Patch update user with valid json with invalid {string}")
    public void patchUpdateUserWithValidJsonWithInvalid(String id) {
        File inv_idjson = new File(Constant.JSON_REQUEST+"/UpdateUser/UpdateUser.json");
        reqresAPI.patchInvalidUpdateUser(id,inv_idjson);
    }

    @And("using PATCH Response body name should be {string},job should be {string}, suit should be {string} and EVA should be {string}")
    public void responseBodyNameShouldBeJobShouldBeSuitColorShouldBeAndEVAShouldBe_PATCH(String name, String job, String suit, String EVA) {
        SerenityRest.then()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job))
                .body(ReqresResponses.SUIT,equalTo(suit))
                .body(ReqresResponses.EVA,equalTo(EVA));
    }
}
