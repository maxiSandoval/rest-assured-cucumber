package bdd.stepDefinition;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import bdd.apis.APIMapsResources;
import bdd.utils.Utils;
import bdd.utils.data.TestDataBuild;

public class PlaceValidationsDefinition extends Utils {

    RequestSpecification request;
    Response response;
    TestDataBuild testDataBuild = new TestDataBuild();
    // to use across test cases
    static String placeId;

    @Given("add Place Payload {string} {string} {string}")
    public void addPlacePayload(String name, String language, String address) throws IOException {
        request = given().spec(requestSpecification())
                .body(testDataBuild.addPlacePayload(name, language, address));
    }

    @When("user calls {string} using {string} http request")
    public void userCallsUsingHttpRequest(String resource, String method) {

        // Constructor will be called with the value of resoruce which is pass
        APIMapsResources resourceAPI = APIMapsResources.valueOf(resource);

        if (method.equalsIgnoreCase("POST")) {
            response = request.when().log().all()
                    .post(resourceAPI.getResource());
        } else if (method.equalsIgnoreCase("GET")) {
            response = request.when().log().all()
                    .get(resourceAPI.getResource());
        }
    }

    @Then("the API call got success with status code {int}")
    public void theApiCallIsSuccessWithStatusCode(int expectedStatusCode) {
        int statusCode = response.getStatusCode();
        assertEquals(expectedStatusCode, statusCode);

    }

    @Then("the value of {string} in response body is {string}")
    public void isInResponseBodyIs(String keyValue, String expectedValue) {
        // This is just an example of automated checking, don't use it as a reference
        // for your test
        assertEquals(expectedValue, getJsPathAsString(response, keyValue));
    }

    @Then("verify place_Id created maps to {string} using {string}")
    public void verifyPlaceIdCreatedMapsToUsing(String expectedName, String resource) throws IOException {
        // requestSpec
        placeId = getJsPathAsString(response, "place_id");
        request = given().spec(requestSpecification())
                    .queryParam("place_id", placeId); 

        userCallsUsingHttpRequest(resource, "GET");

        String actualName = getJsPathAsString(response, "name");
        assertEquals(expectedName, actualName);

    }

    @Given("DeletePlace Payload")
    public void deletePlacePayload() throws IOException {
         request = given().spec(requestSpecification()).body(testDataBuild.deletePlacePayload(placeId));
    }



}
