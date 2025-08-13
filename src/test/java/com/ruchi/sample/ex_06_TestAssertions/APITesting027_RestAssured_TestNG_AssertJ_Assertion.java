package com.ruchi.sample.ex_06_TestAssertions;

import static org.assertj.core.api.Assertions.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting027_RestAssured_TestNG_AssertJ_Assertion {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingId;

    @Test
    public void test_createBooking_POST() {
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
        validatableResponse.statusCode(200);

        // Rest Assured -> import org.hamcrest.Matchers; %4-%5 used
        // Matchers.equalto()
        validatableResponse.body("bookingid", Matchers.notNullValue());
        validatableResponse.body("booking.firstname",Matchers.equalTo("aanya"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Avni"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));
        validatableResponse.body("booking.bookingdates.checkin", Matchers.equalTo("2025-07-01"));

        //TestNG - Extract the details (Variables) of the firstname, bookingId, lastname from Response.
        // TestNG Assertions - 75% used
        // SoftAssert vs HardAssert (90%) used
        // This means that if any assertion fails,
        // the remaining statements in that test method will not be executed.

        // Extraction
        // Concept #1 - Normal( TestNG or Assertj) IS IMP

        bookingId = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");

        Assert.assertEquals(firstname, "aanya");
        Assert.assertEquals(firstname, "Avni");
        Assert.assertNotNull(bookingId);

        // AssertJ( 3rd- Lib to Assertions) - 20%
        assertThat(bookingId).isNotZero().isNotNull().isPositive();
        assertThat(firstname).isNotBlank().isNotEmpty().isNotNull().isEqualTo("aanya");


    }


}
