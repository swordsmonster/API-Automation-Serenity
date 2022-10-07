package com.testautomation.api.runners.stepdefinitons;

import com.testautomation.api.questions.ResponseCode;
import com.testautomation.api.questions.TheFieldsPostServicesResponseAre;
import com.testautomation.api.questions.TheSchemaIs;
import com.testautomation.api.tasks.GetSingleUser;
import com.testautomation.api.tasks.RegisterSuccessful;
import com.testautomation.api.utils.resources.WebServiceEndPoints;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class GetSingleUserStepDefinitions {
    @When("I consume the endpoint with the user id {int}")
    public void i_consume_the_endpoint_with_the_user_id(Integer id) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GetSingleUser.service(WebServiceEndPoints.URI.getUrl(), id)
        );
    }

    @Then("the {int} response code received")
    public void the_response_code_received(Integer codeNumber) {
        OnStage.theActorInTheSpotlight().should(seeThat("The response code", ResponseCode.was(), equalTo(codeNumber)));
    }
    @And("schema received is according to {string}")
    public void schema_received_is_according_to(String schemaResponse) {
        OnStage.theActorInTheSpotlight().should(seeThat(TheSchemaIs.expected(schemaResponse)));
    }
    @And("data values are not empty")
    public void data_values_are_not_empty() {
        OnStage.theActorInTheSpotlight().should(seeThat(TheFieldsPostServicesResponseAre.expected()));
    }

}
