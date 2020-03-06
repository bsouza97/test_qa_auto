# test_qa_auto

Testes Automatizados:
- The first test performed a normal registration from a customer who only consults an investment and after that
validates the final investment value.
- The second test tries to make an investment with less than 20 R$ and after the attempt validates the error displayed.
- The third test only tries to make an investment without any data and validates all errors presented.

To run automated tests on different OS follow the instructions below:

In the ProjectConfig.java file make the following change

Exemple:

Actual - System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

For Windows: System.setProperty("webdriver.chrome.driver", "drivers/wchromedriver.exe");

The API proposed in the test was tested with postman.
Link for collection with tests: https://www.getpostman.com/collections/51adcc93bd3d8e39d626
The tests validate the return of status and body from API.

Acceptance tests:

Link with acceptance tests performed: https://drive.google.com/open?id=1NL45nWU4oLu2KEJFevrm2qjWH3plh1c5

Tools used:

Automated testing: Selenium;

API Tests: Postman;

Acceptance tests: Worksheet to control test performance; 

Enjoy.
