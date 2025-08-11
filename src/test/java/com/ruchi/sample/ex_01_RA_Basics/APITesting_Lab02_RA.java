package com.ruchi.sample.ex_01_RA_Basics;

import io.restassured.RestAssured;

import java.util.Scanner;

public class APITesting_Lab02_RA {
    public static void main(String[] args) {

        // Gherkin Syntax
        //Given() -> Pre-Req. -> URL, Headers, Auth, Body....
        //When() -> HTTP Method? -> GET/POST/PUT/PATCH/DELETE....
        //Then() -> Validation -> 200 OK, firstname == RUCHI

        // Full URl -> https://zippopotam.us/IN/560035
        // Base URI -> https://zippopotam.us
        // Base Path -> /IN/560035

        // take user input - use scanner class

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the pincode!");
        String pincode = sc.next();

        RestAssured.given().baseUri("https://zippopotam.us")
                .basePath("/IN/560035")
                .when().log().all().get()
                .then().log().all().statusCode(200);
    }
}
