package com.testautomation.api.runners.stepdefinitons;

import com.testautomation.api.questions.ResponseCode;
import com.testautomation.api.questions.TheFieldsGetServicesResponseAre;
import com.testautomation.api.questions.TheFieldsPostServicesResponseAre;
import com.testautomation.api.questions.TheSchemaIs;
import com.testautomation.api.tasks.GetUsers;
import com.testautomation.api.tasks.RegisterSuccessful;
import com.testautomation.api.utils.resources.WebServiceEndPoints;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class PostRegisterSuccessfulStepDefinitions {

    @When("I consume the endpoint with email {string} and password {string}")
    public void iConsumeTheEndpointWithEmailAndPassword(String email, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RegisterSuccessful.service(WebServiceEndPoints.URI.getUrl(), email, password)
        );
    }

    @Then("I receive the {int} response code")
    public void iGetTheResponseCode(int codeNumber) {
        OnStage.theActorInTheSpotlight().should(seeThat("The response code", ResponseCode.was(), equalTo(codeNumber)));
    }
    @And("user's schema received is according to {string}")
    public void userSFieldsInTheListAreAccordingTo(String schemaResponse) {
        OnStage.theActorInTheSpotlight().should(seeThat(TheSchemaIs.expected(schemaResponse)));
    }
    @And("id and token are retrieved")
    public void idAndTokenAreRetrieved() {
        OnStage.theActorInTheSpotlight().should(seeThat(TheFieldsPostServicesResponseAre.expected()));
    }

}
