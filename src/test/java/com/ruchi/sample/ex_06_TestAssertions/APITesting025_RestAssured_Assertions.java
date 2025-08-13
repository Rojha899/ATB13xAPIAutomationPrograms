package com.ruchi.sample.ex_06_TestAssertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import org.hamcrest.Matcher;

public class APITesting025_RestAssured_Assertions {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingid;

    @Test
    public void test_createBooking_POST(){
        // payload - copy create booking body from postman
        // given - setting up the body, url, base path, uri
        // when  - making the req
        // then - extraction

        String request_payload = "{\n" +
                "        \"firstname\": \"aanya\",\n" +
                "        \"lastname\": \"Avni\",\n" +
                "        \"totalprice\": 2000,\n" +
                "        \"depositpaid\": true,\n" +
                "        \"bookingdates\": {\n" +
                "            \"checkin\": \"2025-07-01\",\n" +
                "            \"checkout\": \"2025-08-01\"\n" +
                "        },\n" +
                "        \"additionalneeds\": \"Breakfast\"\n" +
                "    }";
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");

        // header information
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(request_payload).log().all();

        response = requestSpecification.when().log().all().post();

        // Get Validate response to perform validation
        validatableResponse = response.then().log().all();

        // Rest Assured. Assertions
        validatableResponse.statusCode(200);

        // Validate bookingid != null; firstname == aanya; lastname == Avni
        // To do so -> We have to extract the response body and validate
        // To extract response body - use jsonpathfinder.com app and get the values

        validatableResponse.body("bookingid", Matchers.notNullValue());
        validatableResponse.body("booking.firstname",Matchers.equalTo("aanya"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Avni"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));
        validatableResponse.body("booking.bookingdates.checkin", Matchers.equalTo("2025-07-01"));

    }
}
