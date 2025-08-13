package com.ruchi.sample.ex_07_Payload_Management.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;


public class APITesting028_RestAssured_Payload_Map {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingId;

    @Test
    public void test_post(){

        //String payload_post = "{\n" +
         //       "        \"firstname\": \"aanya \",\n" +
         //       "        \"lastname\": \"Avni\",\n" +
         //       "        \"totalprice\": 2000,\n" +
         //       "        \"depositpaid\": true,\n" +
         //       "        \"bookingdates\": {\n" +
         //       "            \"checkin\": \"2025-07-01\",\n" +
        //      "            \"checkout\": \"2025-08-01\"\n" +
        //        "        },\n" +
        //        "        \"additionalneeds\": \"Breakfast\"\n" +
        //        "    }";

        // Above commented section we have been using as a string payload so far,now we will use map

        // Hashmap -> key and value pair
        // Parent Hashmap ->  key and value , Child Hashmap

        Map<String, Object> jsonBodyUsingMap = new LinkedHashMap<>(); // parent map

        jsonBodyUsingMap.put("firstname", "aanya");
        jsonBodyUsingMap.put("lastname", "Avni");
        jsonBodyUsingMap.put("totalprice", 123);
        jsonBodyUsingMap.put("depositpaid", true);

        Map<String, Object> bookingDatesMap = new LinkedHashMap<>(); // Child map

        bookingDatesMap.put("checkin", "2025-07-01"); // YYYY-DD-MM
        bookingDatesMap.put("checkout", "2025-08-01");

        jsonBodyUsingMap.put("bookingdates", bookingDatesMap );
        jsonBodyUsingMap.put("additionalneeds", "Breakfast");

        System.out.println(jsonBodyUsingMap);

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonBodyUsingMap).log().all();

        Response response = requestSpecification.when().post();

        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Rest Assured -> import org.hamcrest.Matchers; %4-%5
        // Matchers.equalto()

        validatableResponse.body("booking.firstname", Matchers.equalTo("aanya"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Avni"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));
        validatableResponse.body("bookingid", Matchers.notNullValue());




    }
}

