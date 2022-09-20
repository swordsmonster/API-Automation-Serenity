package com.testautomation.api.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.*;

public class TheFieldsGetServicesResponseAre implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(seeThatResponse("Validating users fields",
                // Check support fields in body
                /*response -> response.assertThat().body("$", Matchers.hasKey("support"))
                        .and().body("support", Matchers.hasKey("url"))
                        .and().body("support", Matchers.hasKey("text"))
                )*/
                // Check key fields in data array according to requirements
                response -> response.assertThat().body("data", everyItem(Matchers.hasKey("id")))
                        .and().body("data", everyItem(Matchers.hasKey("email")))
                        .and().body("data", everyItem(Matchers.hasKey("first_name")))
                        .and().body("data", everyItem(Matchers.hasKey("last_name")))
                        .and().body("data", everyItem(Matchers.hasKey("avatar")))
                )
        );
        return true;
    }
    public static TheFieldsGetServicesResponseAre expected() {
        return new TheFieldsGetServicesResponseAre();
    }
}
