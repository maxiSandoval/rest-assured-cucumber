package bdd.resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
    
    // This kind of variable is share across the execution
    public static RequestSpecification requestSpec;
    
    ResponseSpecification responseSpec;

    // Create a general Request type
    public RequestSpecification requestSpecification() throws IOException {

        if (requestSpec == null) {
            // This PrintStream allow us to write in .txt file
            // content is put into the file
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
            requestSpec = new RequestSpecBuilder()
                    .setBaseUri(getGlobalValue("baseUrl"))
                    .addQueryParam("key", "qaclick123")
                    // .addFilter allow us to configure a logger for request and response
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON)
                    .build();

            return requestSpec;
        }
        return requestSpec;
    }

    public ResponseSpecification responseSpecification() {

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();

        return responseSpec;
    }

    public static String getGlobalValue(String key) throws IOException {
        // Allow us to scan every .properties files
        Properties prop = new Properties();
        // Here we are reading the file
        FileInputStream fis = new FileInputStream(
                "C:\\Source\\rest-assured\\rest-assured-cucumber\\rest-assured-cucumber\\src\\test\\java\\bdd\\resources\\global.properties");
        // load the file information in Properties variable
        prop.load(fis);
        return prop.getProperty(key);
    }

    public String getJsPathAsString(Response response, String key){
        String responseString = response.asString();
        JsonPath jsPath = new JsonPath(responseString);
        return jsPath.get(key).toString();
    }
}
