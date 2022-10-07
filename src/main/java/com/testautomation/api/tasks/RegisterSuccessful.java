package com.testautomation.api.tasks;

import com.testautomation.api.interactions.ExecuteGet;
import com.testautomation.api.interactions.ExecutePost;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;


public class RegisterSuccessful implements Task {

    private final String resource;
    private final String email;
    private final String password;

    public RegisterSuccessful(String resource, String email, String password) {
        this.resource = resource;
        this.email = email;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(ExecutePost.service(resource, email, password));
    }

    public static RegisterSuccessful service(String resource, String email, String password){
        return Tasks.instrumented(RegisterSuccessful.class, resource, email, password);
    }
}
