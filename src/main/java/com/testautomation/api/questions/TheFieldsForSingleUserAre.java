package com.testautomation.api.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class TheFieldsForSingleUserAre implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(seeThatResponse("Not empty",
                        // Check key fields in response according to requirements
                        response -> response.assertThat().body("data", Matchers.hasKey("id"))
                                .and().body("data", Matchers.hasKey("email"))
                                .and().body("data", Matchers.hasKey("first_name"))
                                .and().body("data", Matchers.hasKey("last_name"))
                                .and().body("data", Matchers.hasKey("avatar"))
                )
        );
        return true;
    }
    public static TheFieldsForSingleUserAre expected() {
        return new TheFieldsForSingleUserAre();
    }
}
