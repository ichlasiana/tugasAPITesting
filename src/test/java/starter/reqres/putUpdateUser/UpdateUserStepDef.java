package starter.reqres.putUpdateUser;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class UpdateUserStepDef {
    @Given("Put update user with valid json with id {int}")
    public void putUpdateUserWithValidJsonWithId(int arg0) {
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
    }

    @And("Validate json schema update user")
    public void validateJsonSchemaUpdateUser() {
    }

    @Given("Put update user with valid json but nothing changed with id {int}")
    public void putUpdateUserWithValidJsonButNothingChangedWithId(int arg0) {
    }

    @And("Validate json schema update user with no data changed")
    public void validateJsonSchemaUpdateUserWithNoDataChanged() {
    }

    @Given("Put update user with valid json that contain more variable with id {int}")
    public void putUpdateUserWithValidJsonThatContainMoreVariableWithId(int arg0) {
    }

    @And("Validate json schema update user with more variable")
    public void validateJsonSchemaUpdateUserWithMoreVariable() {
    }

    @Given("Put update user with invalid json with id {int}")
    public void putUpdateUserWithInvalidJsonWithId(int arg0) {
    }

    @Given("Put update user with valid json with invalid {string}")
    public void putUpdateUserWithValidJsonWithInvalid(String arg0) {
    }
}
