Feature: Validating Place API's

  Scenario: Verify if Place is being Succesfully added using addPlaceAPI
    Given add Place Payload "<name>" "<language>" "<address>" 
    When user calls "addPlaceAPI" using Post http request
    Then the API call got success with status code 200
    Then the value of "status" in response body is "OK"
    And the value of "scope" in response body is "APP"

    Examples:
      | name  | language | address         |
      | maxi  | English  | Huaso campesino |
      | fenix | English  | Parcela 3       |

