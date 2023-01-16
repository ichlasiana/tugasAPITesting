package starter.reqres.putUpdateUser;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.Constant;
import starter.reqres.postRegisterUser.ReqresAPI_POST_RegisterUser;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class UpdateUserStepDef {

    @Steps
    ReqresAPI_PUT_UpdateUser reqresAPI;
    @Given("Put update user with valid json with id {int}")
    public void putUpdateUserWithValidJsonWithId(int id) {
        File jsonValid = new File(Constant.JSON_REQUEST+"/UpdateUser/UpdateUser.json");
        reqresAPI.putUpdateUser(id,jsonValid);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI_PUT_UpdateUser.PUT_UPDATE_USER);
    }

    @And("Validate json schema update user")
    public void validateJsonSchemaUpdateUser() {
        File validJsonSchema = new File(Constant.JSON_SCHEMA+"/UpdateUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(validJsonSchema));
    }

    @Given("Put update user with valid json that contain more variable with id {int}")
    public void putUpdateUserWithValidJsonThatContainMoreVariableWithId(int id) {
        File morevar_json = new File(Constant.JSON_REQUEST+"/UpdateUser/UpdateUser_moreVar.json");
        reqresAPI.putUpdateUser(id,morevar_json);
    }

    @And("Validate json schema update user with more variable")
    public void validateJsonSchemaUpdateUserWithMoreVariable() {
        File moreVar_jsonSchema = new File(Constant.JSON_SCHEMA+"/UpdateUserMoreVar_Schema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(moreVar_jsonSchema));
    }

    @Given("Put update user with invalid json with id {int}")
    public void putUpdateUserWithInvalidJsonWithId(int id) {
        File invjson = new File(Constant.JSON_REQUEST+"/UpdateUser/UpdateUser_Invld.json");
        reqresAPI.putUpdateUser(id,invjson);
    }

    @Given("Put update user with valid json with invalid {string}")
    public void putUpdateUserWithValidJsonWithInvalid(String id) {
        File inv_idjson = new File(Constant.JSON_REQUEST+"/UpdateUser/UpdateUser.json");
        reqresAPI.putInvalidUpdateUser(id,inv_idjson);
    }

    @And("Response body name should be {string},job should be {string}, suit should be {string} and EVA should be {string}")
    public void responseBodyNameShouldBeJobShouldBeSuitColorShouldBeAndEVAShouldBe(String name, String job, String suit, String EVA) {
        SerenityRest.then()
                .body("name", equalTo(name))
                .body("job",equalTo(job))
                .body("suit",equalTo(suit))
                .body("EVA",equalTo(EVA));
    }
}
