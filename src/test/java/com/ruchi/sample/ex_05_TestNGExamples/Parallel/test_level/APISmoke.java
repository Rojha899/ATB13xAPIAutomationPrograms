package com.ruchi.sample.ex_05_TestNGExamples.Parallel.test_level;

import org.testng.annotations.Test;

public class APISmoke {
    @Test
    public void test_API_Smoke(){
        System.out.println(Thread.currentThread().getId());
    }
}
