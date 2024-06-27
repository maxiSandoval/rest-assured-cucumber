package bdd.resources;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {

    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;

    public RequestSpecification requestSpecification() throws FileNotFoundException {

        //  This PrintStream allow us to write in .txt file
        PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("key", "qaclick123")
                // .addFilter allow us to configure a logger for request and response 
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType(ContentType.JSON)
                .build();

        return requestSpec;
    }

    public ResponseSpecification responseSpecification() {

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();

        return responseSpec;
    }
}
