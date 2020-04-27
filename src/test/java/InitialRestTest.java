import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class InitialRestTest {

    private static final String restApiUrl = "https://reqres.in/api/";

    @Test
    public void getUser(){

        Actor jorge = Actor.named("Jorge")
                .whoCan(CallAnApi.at(restApiUrl));

        jorge.attemptsTo(
                Get.resource("users?page=2")
        );

        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(200);
    }
}
