Feature: Validating Place API's

  Scenario: Verify if Place is being Succesfully added using addPlaceAPI
    Given Add Place Payload
    When user calls "addPlaceAPI" using Post http request
    Then the API call got success with status code 200
    Then the value of "status" in response body is "OK"
    And the value of "scope" in response body is "APP"
    
