package com.ruchi.sample.ex_05_TestNGExamples.Parallel.class_level_cross_browser_testing;

import org.testng.annotations.Test;

public class FirefoxTest {
    @Test
    public void test_firefox(){
        System.out.println("2");
        System.out.println(Thread.currentThread().getId());

    }
}
