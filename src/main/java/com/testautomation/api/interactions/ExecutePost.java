package com.testautomation.api.interactions;

import com.testautomation.api.models.InfoRegisterUser;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class ExecutePost implements Interaction{
    private final String resource;
    private final String email;
    private final String password;

    public ExecutePost(String resource, String email, String password) {

        this.resource = resource;
        this.email = email;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor){

        InfoRegisterUser Information = new InfoRegisterUser();
        Information.setEmail(email);
        Information.setPassword(password);

        SerenityRest.reset();
        actor.attemptsTo(
                Post.to(resource).with(requestSpecification -> requestSpecification
                        .contentType(ContentType.JSON).body(Information)
                )
        );
    }

    public static ExecutePost service(String resource, String email, String password){
        return Tasks.instrumented(ExecutePost.class, resource, email, password);
    }
}
