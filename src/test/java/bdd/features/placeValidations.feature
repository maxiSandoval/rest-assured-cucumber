Feature: Validating Place API's

Scenario: Verify if Place is being Succesfully added using addPlaceAPI
    Given Add Place Payload
    When user calls addPlaceAPI using Post http request
    Then the API call is success with status code 200
    And status in response body is OK