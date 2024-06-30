Feature: Validating Place API's

  @AddPlace
  Scenario: Verify if Place is being Succesfully added using addPlaceAPI
    Given add Place Payload "<name>" "<language>" "<address>"
    When user calls "ADD_PLACE_API" using "Post" http request
    Then the API call got success with status code 200
    And the value of "status" in response body is "OK"
    And the value of "scope" in response body is "APP"
    And verify place_Id created maps to "<name>" using "GET_PLACE_API"

    Examples:
      | name  | language | address   |
      #      | maxi  | English  | Huaso campesino |
      | fenix | English  | Parcela 3 |

  @DeletePlace
  Scenario: Verify if Delete Place functionality is working
    Given DeletePlace Payload
    When user calls "DELETE_PLACE_API" using "Post" http request
    Then the API call got success with status code 200
    And the value of "status" in response body is "OK"