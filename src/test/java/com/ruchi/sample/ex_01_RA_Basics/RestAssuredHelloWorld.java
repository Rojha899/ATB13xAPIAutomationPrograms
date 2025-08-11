package com.ruchi.sample.ex_01_RA_Basics;

import io.restassured.RestAssured;

public class RestAssuredHelloWorld {
    public static void main(String[] args) {
        // https://restful-booker.herokuapp.com/ping
        // verify response code HTTP/1.1 201 Created

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .when().log().all().get()

                .then().log().all().statusCode(201);


    }
}
