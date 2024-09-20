@Activity6

Scenario: Testing using the Data

  Given User completed Req

  When User logins with below username and password

    | admin     | password |
    | adminUser | Password |
    | adminUser |          |

  Then Verify the results

Scenario: Testing using the To-Do application

  Given User completes requirement

  When User enters expected Tasks

    | task1 |
    | task2 |
    | task3 |

  Then Verify the results