package com.testautomation.api.tasks;

import com.testautomation.api.interactions.ExecuteGet;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class GetSingleUser implements Task {

    private final String resource;
    private final int id;

    public GetSingleUser(String resource, int id) {
        this.resource = resource;
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(ExecuteGet.service(resource, id));
    }

    public static GetSingleUser service(String resource, int id){
        return Tasks.instrumented(GetSingleUser.class, resource, id);
    }
}
