package com.testautomation.api.runners.stepdefinitons;

import com.testautomation.api.questions.*;
import com.testautomation.api.tasks.GetUsers;
import com.testautomation.api.tasks.RegisterSuccessful;
import com.testautomation.api.utils.resources.WebServiceEndPoints;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class GetUsersStepDefinitions {

    @When("I consume the endpoint to get the {string} {int} from the user's list")
    public void iConsumeTheEndpointToGetThePageFromTheUserSList(String parameter, int page) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GetUsers.service(WebServiceEndPoints.URI.getUrl(), parameter, page)
        );
    }
    @When("I consume the endpoint to get the user {string} {int}")
    public void iConsumeTheEndpointToGetTheUser(String parameter, int page) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GetUsers.service(WebServiceEndPoints.URI.getUrl(), parameter, page)
        );
    }
    @Then("I get the {int} response code")
    public void iGetTheResponseCode(int codeNumber) {
        OnStage.theActorInTheSpotlight().should(seeThat("The response code", ResponseCode.was(), equalTo(codeNumber)));
    }
    @And("user's schema is according to {string}")
    public void userSFieldsInTheListAreAccordingTo(String schemaResponse) {
        OnStage.theActorInTheSpotlight().should(seeThat(TheSchemaIs.expected(schemaResponse)));
    }
    @And("user's fields exist for each user")
    public void userSFieldsExist() {
        OnStage.theActorInTheSpotlight().should(seeThat(TheFieldsGetServicesResponseAre.expected()));
    }
    @And("user fields are not empty")
    public void userFieldsAreNotEmpty() {
        OnStage.theActorInTheSpotlight().should(seeThat(TheFieldsForSingleUserAre.expected()));
    }
}

