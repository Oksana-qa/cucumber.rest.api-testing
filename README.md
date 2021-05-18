# cucumber.rest.api-testing

In current repository you can find a series of automated tests that cover a few scenarios with the help of Cucumber:
- get authorisation error when I request data with wrong credentials
- get data from the REST API
- get "not found" error when I request data from the REST API with wrong id
- get "wrong format" error when I request data from the REST API with wrong id format

For verifying the code please open https://jsonbin.io/api-reference and sign in with your credentials 

Next open API KEYS page, copy the key and put it in the auth.data file and String API_KEY variable
