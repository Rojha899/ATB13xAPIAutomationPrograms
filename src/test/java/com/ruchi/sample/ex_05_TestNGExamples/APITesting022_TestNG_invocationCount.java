package com.ruchi.sample.ex_05_TestNGExamples;

import org.testng.annotations.Test;

public class APITesting022_TestNG_invocationCount {

    // Invocationcount = How many times you want to run test

    @Test(invocationCount = 2) // this will run 2 times
    public void test01(){
        System.out.println("Hi");
    }

    @Test(invocationCount = 3) // this will run 3 times
    public void test02(){
        System.out.println("Bye");
    }
}
