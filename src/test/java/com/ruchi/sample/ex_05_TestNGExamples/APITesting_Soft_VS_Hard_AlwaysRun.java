package com.ruchi.sample.ex_05_TestNGExamples;

import org.testng.annotations.Test;

public class APITesting_Soft_VS_Hard_AlwaysRun {
    @Test
    public void login() { /* might fail */ }

    @Test(dependsOnMethods = "login")         // Hard dependency
    public void placeOrder() { /* runs only if login passed */ }

    @Test(dependsOnMethods = "login", alwaysRun = true)  // Soft dependency
    public void closeBrowser() { /* runs even if login failed */ }
}
