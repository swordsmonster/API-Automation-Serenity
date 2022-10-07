package com.testautomation.api.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.*;

public class TheFieldsPostServicesResponseAre implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(seeThatResponse("Validating users fields",
                // Check key fields in data array according to requirements
                response -> response.assertThat().body("id", is(4))
                        .and().body("token", containsString("QpwL5tke4Pnpja7X4"))
                )
        );
        return true;
    }
    public static TheFieldsPostServicesResponseAre expected() {
        return new TheFieldsPostServicesResponseAre();
    }
}
