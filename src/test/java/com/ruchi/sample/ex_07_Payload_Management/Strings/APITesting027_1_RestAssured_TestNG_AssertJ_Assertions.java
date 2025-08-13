package com.ruchi.sample.ex_07_Payload_Management.Strings;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting027_1_RestAssured_TestNG_AssertJ_Assertions {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingId;

    @Test
    public void test_post(){
        String name = "Amit";
        String payload_post = "{\n" +
                "        \"firstname\": \""+name+" \",\n" +
                "        \"lastname\": \"Avni\",\n" +
                "        \"totalprice\": 2000,\n" +
                "        \"depositpaid\": true,\n" +
                "        \"bookingdates\": {\n" +
                "            \"checkin\": \"2025-07-01\",\n" +
                "            \"checkout\": \"2025-08-01\"\n" +
                "        },\n" +
                "        \"additionalneeds\": \"Breakfast\"\n" +
                "    }";


    }
}
