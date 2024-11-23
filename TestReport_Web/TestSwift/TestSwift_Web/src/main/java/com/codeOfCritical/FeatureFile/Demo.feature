Feature: Demo BDD FRAMEWORK

  @t1
  Scenario Outline: Verifying the title length of the Websites "<url>"
    Given I open "<url>" url
    When I search for title length 11
    Then It will be length of "<len>"

    Examples:
      | url                   | len |
      | https://google.com    | 99  |
      | https://bing.com      | 11  |
      | https://www.yahoo.com | 112 |





#    Then I verify the window title
#      | FileName                        | Identifier |
#      | /TestData/TestDataCustoner.xlsx | SL-TS01-01 |
