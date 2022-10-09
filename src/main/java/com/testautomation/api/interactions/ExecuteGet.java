package com.testautomation.api.interactions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ExecuteGet implements Interaction {
    private final String resource;
    private final String paramName;
    private final int param;

    public ExecuteGet(String resource, String paramName, int param) {
        this.resource = resource;
        this.paramName = paramName;
        this.param = param;
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        SerenityRest.reset();
        actor.attemptsTo(
                Get.resource(resource).with(request -> request.params(paramName, param))
        );
    }

    public static ExecuteGet service(String resource, String paramName, int param){
        return Tasks.instrumented(ExecuteGet.class, resource, paramName, param);
    }
}

