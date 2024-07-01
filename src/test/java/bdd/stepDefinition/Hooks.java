package bdd.stepDefinition;

import java.io.IOException;

import io.cucumber.java.Before;

// We can set up pre-conditions, post-conditions for our tests
public class Hooks {
    
    @Before("@DeletePlace")
    public void beforeDeleteScenario() throws IOException{
        // execute this code only when place_id is null
        // write a code that will give you place_id
        PlaceValidationsDefinition placeValdefinition = new PlaceValidationsDefinition();
        
        if (PlaceValidationsDefinition.placeId == null) {
            placeValdefinition.addPlacePayload("Maxi", "English", "Huaso loco");
            placeValdefinition.userCallsUsingHttpRequest("ADD_PLACE_API", "post");
            placeValdefinition.verifyPlaceIdCreatedMapsToUsing("Maxi", "GET_PLACE_API");
        }
     
    }
}
