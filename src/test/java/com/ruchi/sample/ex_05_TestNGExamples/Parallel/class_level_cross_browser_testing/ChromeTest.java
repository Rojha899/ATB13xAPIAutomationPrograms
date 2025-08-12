package com.ruchi.sample.ex_05_TestNGExamples.Parallel.class_level_cross_browser_testing;

import org.testng.annotations.Test;

public class ChromeTest {
    @Test
    public void test_chrome1(){
        System.out.println("1");
        System.out.println(Thread.currentThread().getId());
    }

    @Test
    public void test_chrome2(){
        System.out.println("1");
        System.out.println(Thread.currentThread().getId());
    }
}
