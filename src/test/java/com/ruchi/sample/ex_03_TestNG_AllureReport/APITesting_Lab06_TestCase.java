package com.ruchi.sample.ex_03_TestNG_AllureReport;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting_Lab06_TestCase {
    // TC in lab05 does not look good - Here we are going to write same TCs by creating methods

    String pincode;
    @Test
    // TC1 - Input data 11048
    public void test_tc1_pincode_valid(){
        pincode = "110048";
        RestAssured.given().baseUri("https://zippopotam.us")
                .basePath("/IN/" +pincode)
                .when().log().all().get()
                .then().log().all().statusCode(200);
    }
    @Test
    // TC2 - Input data @. $, # any special character
    public void test_tc2_pincode_invalid(){
        pincode = "@";
        RestAssured.given().baseUri("https://zippopotam.us")
                .basePath("/IN/" +pincode)
                .when().log().all().get()
                .then().log().all().statusCode(200);
    }

    @Test
    // TC3 - Input data ' ' blank
    public void test_tc3_pincode_invalid(){
        pincode = " ";
        RestAssured.given().baseUri("https://zippopotam.us")
                .basePath("/IN/" +pincode)
                .when().log().all().get()
                .then().log().all().statusCode(200);
    }

}
