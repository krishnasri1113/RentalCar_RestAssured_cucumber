$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("RentalcarFeatureFile.feature");
formatter.feature({
  "line": 1,
  "name": "Rental Car test Get request and verify the response using Rest Assured",
  "description": "",
  "id": "rental-car-test-get-request-and-verify-the-response-using-rest-assured",
  "keyword": "Feature"
});
formatter.before({
  "duration": 1145905400,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "stubbingmapping for getrequest",
  "keyword": "Given "
});
formatter.match({
  "location": "stepdefinitionfile.stubbingmapping_for_getrequest()"
});
formatter.result({
  "duration": 101925700,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Return all cars which have lowest per day price and price after discount",
  "description": "",
  "id": "rental-car-test-get-request-and-verify-the-response-using-rest-assured;return-all-cars-which-have-lowest-per-day-price-and-price-after-discount",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 13,
      "name": "@tag2"
    }
  ]
});
formatter.step({
  "line": 15,
  "name": "user calls the get request API with GET http request",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "user should see the response body",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "The API call got the success with status code 200",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "Return all cars which have  the lowest per day price",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "Return all cars which have lowest  the per day price after discount",
  "keyword": "Then "
});
formatter.match({
  "location": "stepdefinitionfile.user_calls_the_get_request_API_with_GET_http_request()"
});
formatter.result({
  "duration": 1173987200,
  "status": "passed"
});
formatter.match({
  "location": "stepdefinitionfile.user_should_see_the_response_body()"
});
formatter.result({
  "duration": 13803900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 46
    }
  ],
  "location": "stepdefinitionfile.the_API_call_got_the_success_with_status_code(int)"
});
formatter.result({
  "duration": 2337100,
  "status": "passed"
});
formatter.match({
  "location": "stepdefinitionfile.return_all_cars_which_have_the_lowest_per_day_price()"
});
formatter.result({
  "duration": 405623400,
  "status": "passed"
});
formatter.match({
  "location": "stepdefinitionfile.return_all_cars_which_have_lowest_the_per_day_price_after_discount()"
});
formatter.result({
  "duration": 137140700,
  "status": "passed"
});
formatter.after({
  "duration": 6302300,
  "status": "passed"
});
});