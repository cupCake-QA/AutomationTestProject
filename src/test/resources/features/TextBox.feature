Feature:Text Box
  @test1-2
  Scenario Outline: Verify correct results are displayed when user enters valid data
    Given the user navigates to "Text Box" page
    When the user enters "<Full Name>", "<Email>", "<Current Address>", "<Permanent Address>"
    And the user clicks on text box submit button
    Then the correct "<Full Name>", "<Email>", "<Current Address>", "<Permanent Address>" should be displayed

    Examples:
      | Full Name   | Email                     | Current Address                  | Permanent Address            |
      | test user   | test@blabla.com           | C. Dobla, 5, 28054 Madrid, Spain | Street X, 28013 Madrid, Spain|
      | John Smith  | john.smith@mailinator.com | Street Smith 3, London, UK       | Street Smith 6, London, UK   |

  @test3
  Scenario Outline: Verify error indicator and no output when user enters invalid email
    Given the user navigates to "Text Box" page
    When the user enters invalid "<Email>"
    And the user clicks on text box submit button
    Then email input has error indicator and there is no output

    Examples:
      | Email                      |
      | thisisnotanemail           |
      | thisisnotanemail@          |
      | thisisnotanemail@blabla    |