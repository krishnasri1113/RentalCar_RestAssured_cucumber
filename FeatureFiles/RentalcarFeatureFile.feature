Feature: Rental Car test Get request and verify the response using Rest Assured

Background:
Given stubbingmapping for getrequest

@tag1
Scenario: Perform simple get request and verify the response and return all blue Teslas
When   user calls the get request API with GET http request
Then  user should see the response body
And The API call got the success with status code 200
Then get all blue Teslas from the response

@tag2
Scenario: Return all cars which have lowest per day price and price after discount
When   user calls the get request API with GET http request
Then  user should see the response body
And The API call got the success with status code 200
Then Return all cars which have  the lowest per day price
Then Return all cars which have lowest  the per day price after discount

@tag3
Scenario: Return  all cars which have highest Revenue genarated
When   user calls the get request API with GET http request
Then  user should see the response body
And The API call got the success with status code 200
Then Return all cars which have  the highest  Revenue



