package com.ruchi.sample.ex_04_RestAssured_HTTP_Methods.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting009_GET_NonBDDStyle {

    RequestSpecification r;      // pre request - given part
    Response response;          // making the request - when
    ValidatableResponse vr;    // post request - then

    String pincode;

    @Test
    public void test_GET_NonBDD(){
        pincode = "560048";

        // Part1 - RequestSpecification r;   --> pre request - given part

        r = RestAssured.given();
        r.baseUri("https://zippopotam.us");
        r.basePath("/IN/" +pincode);

        // Part2 - Response response;         --> making the request - when
        response = r.when().log().all().get();

        // Part3 - ValidatableResponse vr;    -->  post request - then
        vr = response.then().log().all();
        vr.statusCode(200);
    }

    @Test
    public void test_GET_NonBDD_Negative(){
        pincode = "@";

        // Part1 - GIVEN
        r = RestAssured.given();
        r.baseUri("https://zippopotam.us");
        r.basePath("/IN/" +pincode);


        // Part2 - WHEN
        response = r.when().log().all().get();


        // Part3 - THEN
        vr = response.then().log().all();
        vr.statusCode(404);
    }
}
