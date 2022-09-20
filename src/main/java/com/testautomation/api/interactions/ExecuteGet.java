package com.testautomation.api.interactions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ExecuteGet implements Interaction {
    private final String resource;
    private final int page;

    public ExecuteGet(String resource, int page) {
        this.resource = resource;
        this.page = page;
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        SerenityRest.reset();
        actor.attemptsTo(
                Get.resource(resource).with(request -> request.queryParam("page",page))
        );
    }

    public static ExecuteGet service(String resource, int page){
        return Tasks.instrumented(ExecuteGet.class, resource, page);
    }
}

