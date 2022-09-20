package com.testautomation.api.tasks;
import com.testautomation.api.interactions.ExecuteGet;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class GetUsers implements Task{
    private final String resource;
    private final int page;

    public GetUsers(String resource, int page) {
        this.resource = resource;
        this.page = page;
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(ExecuteGet.service(resource, page));
    }

    public static GetUsers service(String resource, int page){
        return Tasks.instrumented(GetUsers.class, resource, page);
    }
}
