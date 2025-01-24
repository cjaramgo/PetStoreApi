# API Automation Challenge - PetStore - OpenAPI 3.0

Proposed Test cases for Automation:
----------------------
**Pets**
1. Create a new pet (POST)
2. Delete an existing Pet (DELETE)
3. Get a pet detail by its ID (GET)
4. Get all pets by status (GET)
5. Get all pets by tags (GET)
6. Update an existing Pet (PUT)
7. Verify invalid pet by its ID (GET)

**Store (Orders)**

1. Place a new order for a pet (POST)
2. Get an order detail by its ID (GET)
3. Delete an existing Order (DELETE)
4. Get all pet inventory by status (GET)
5. Verify an invalid order ID (GET)


**Users**
1. Create a new user (POST)
2. Delete an existing user (DELETE)
3. Get a user detail by its username (GET)
4. Log in user (GET)
5. Update an existing user (GET)
6. Verify a non-existent user (GET)


Setup Instructions (Macbook)
----------------------

1. Clone the repository:
```
https://github.com/cjaramgo/PetStoreApi.git
```
2. Install Maven. Run following command in terminal -> ```brew install maven```
3. Install Allure. Run following command in terminal -> ```brew install allure```
	
Run Automated Tests on Terminal
----------------------
1. Go to 'PetStoreApi' folder from command line
2. Run following command -> ``` mvn clean test```

Run reports with Allure reports
----------------------
1. On 'PetStoreApi' folder
2. Run following command -> ```allure serve allure-results```
3. Allure reports will be opened in the browser.


How it was implemented?
----------------------
1. The project was created following some practices. This framework was implemented with ```Java``` and ```REST-assured```, ```Maven``` as build automation tool, The runner used is ```Junit5``` and the reports are in ```Allure-Reports```
2. It was implemented a ```model``` package that contains all the DataModels (POJOs) for Users, Pets and Orders with the Getters and Setters definition.
2. A package called ```payloads``` contains all the payloads the ```Java-faker``` library was used to create dummy data
3. The package ```requests``` contains all the http methods and requests necessary to make requests to the API
4. The package ```utils``` contains some handy methods to support some actions
5. The package ```tests``` contains all the test that were implemented on this framework

 
### Author
- Carlos Andres Jaramillo