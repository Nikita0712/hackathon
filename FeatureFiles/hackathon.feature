Feature: finding the interest amount of current year
 
  @sanity @regression
  Scenario: interest and amount 
    Given user is navigating to emi calculator site
    When User is filling car loan details
    And user is getting principal and interest amount for one month
    When User is clicking home loan calculator
    When User is filling home loan details 
    When user is storing home loan details for a year in excel 
    When User is clicking loan calculator
    Then user is validating UI for text box & scales
    And user is changing the Loan tenure for year & month
    When User is clicking loan amount calculator
    Then user is validating UI for text box & scales for loan amount
    And user is changing the Loan tenure for year & month for loan amount
    When User is clicking loan tenure calculator
    Then user is validating UI for text box & scales for loan tenure
    
    
     