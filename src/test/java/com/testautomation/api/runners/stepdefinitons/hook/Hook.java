package com.testautomation.api.runners.stepdefinitons.hook;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

public class Hook {
    private EnvironmentVariables environmentVariables;

    @Before
    public void configureBaseUrl(){
        // Creating a scene
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Reqres");

        // Getting the URL value according to configured variable in "serenity.conf" file
        String baseRestApiUrl = String.valueOf(environmentVariables.optionalProperty("environments.qa.base.url")
                .orElse("environments.dev.base.url"));

        // Calling the retrieved API URL
        OnStage.theActorInTheSpotlight().whoCan(CallAnApi.at(baseRestApiUrl));

    }
}
