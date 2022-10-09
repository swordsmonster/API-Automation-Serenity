package com.testautomation.api.tasks;
import com.testautomation.api.interactions.ExecuteGet;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class GetUsers implements Task{
    private final String resource;
    private final String paramName;
    private final int param;


    public GetUsers(String resource, String paramName, int param) {
        this.resource = resource;
        this.paramName = paramName;
        this.param = param;
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(ExecuteGet.service(resource, paramName, param));
    }

    public static GetUsers service(String resource, String paramName, int param){
        return Tasks.instrumented(GetUsers.class, resource, paramName, param);
    }
}
