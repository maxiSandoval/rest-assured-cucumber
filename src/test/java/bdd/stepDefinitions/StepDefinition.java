package bdd.stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import bdd.resources.TestDataBuild;
import bdd.resources.Utils;

public class StepDefinition extends Utils{

    RequestSpecification request;
    Response response;
    TestDataBuild testDataBuild = new TestDataBuild();

    @Given("add Place Payload {string} {string} {string}")
    public void addPlacePayload(String name, String language, String address) throws IOException {
        request = given().spec(requestSpecification()).body(testDataBuild.addPlacePayload(name, language, address));
    }

    @When("user calls {string} using Post http request")
    public void user_calls_using_Post_http_request(String s) {
        response = request.when().log().all()
                .post("maps/api/place/add/json")
                .then().log().all()
                .spec(responseSpecification())
                .extract().response();
    }

    @Then("the API call got success with status code {int}")
    public void the_API_call_is_success_with_status_code(int expectedStatusCode) {
        int statusCode = response.getStatusCode();
        assertEquals(expectedStatusCode, statusCode);

    }

    @Then("the value of {string} in response body is {string}")
    public void is_in_response_body_is(String keyValue, String expectedValue) {
        // This is just an example of automated checking, don't use it as a reference for your test
        String responseString = response.asString();
        JsonPath jsPath = new JsonPath(responseString);
        String obtainedValue = jsPath.get(keyValue);
        assertEquals(expectedValue, obtainedValue);

    }
}
