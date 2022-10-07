package com.testautomation.api.interactions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ExecuteGetSingle implements Interaction {
    private final String resource;
    private final int id;

    public ExecuteGetSingle(String resource, int id) {
        this.resource = resource;
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        SerenityRest.reset();
        actor.attemptsTo(
                Get.resource(resource).with(request -> request.param(String.valueOf(id)))
        );
    }

    public static ExecuteGet service(String resource, int id){
        return Tasks.instrumented(ExecuteGet.class, resource, id);
    }
}
