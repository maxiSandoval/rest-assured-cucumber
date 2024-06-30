package bdd.stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

// We can set up pre-conditions for our tests
public class Hooks {
    
    @Before("@DeletePlace")
    public void beforeDeleteScenario() throws IOException{
        // execute this code only when place_id is null
        // write a code that will give you place_id
        StepDefinition step = new StepDefinition();
        
        if (StepDefinition.placeId == null) {
            step.addPlacePayload("Maxi", "English", "Huaso loco");
            step.userCallsUsingHttpRequest("ADD_PLACE_API", "post");
            step.verifyPlaceIdCreatedMapsToUsing("Maxi", "GET_PLACE_API");
        }
     
    }
}
