package com.ruchi.sample.ex_04_RestAssured_HTTP_Methods.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting010_POST_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_POST_NonBDDStyle_Create_Token(){
        // URL - https://restful-booker.herokuapp.com/auth
        // PAYLOAD - {
        //    "username" : "admin",
        //    "password" : "password123"
        //}
        // HEADER - Content-Type : application/json
        // Auth? - NA
        // Cookie ? - NA
        // Validate - 200 Ok
        // Body Response  - Token is generated or not.

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";  //just paste the payload in "" \n or \ will be automatically added

        System.out.println("------ Part-1 ----------");
        // Part 1 - Pre Condition - Preparing Request - URL, Headers, Auth...
        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON);
        // r.header("Content-length","1000"); // adding header
        // r.auth().basic("admin","password123"); // basic authentication
        // r.auth().oauth2("ey39102930192dsd); // oauth2 will have unique token
        //r.header("Authorization","Bearer ey239823820328083"); // adding bearer
        r.body(payload).log().all();

        System.out.println("------ Part-2 ----------");
        // Making HTTP Request -> Part 2
        response = r.when().log().all().post();

        System.out.println("------ Part-3 ----------");
        // Verification Part -> Part 3
        vr = response.then().log().all();
        vr.statusCode(200);
    }
}
