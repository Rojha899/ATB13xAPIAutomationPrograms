package com.ruchi.sample.ex_02_RA_Concepts;

public class APITesting_Lab03_NP {
    //No Design / non-builder Pattern

    public void step1 (){
        System.out.println("Step1");
    }
    public void step2 (){
        System.out.println("Step2");
    }
    public void step3 (String param1){
        System.out.println("Step3");
    }

    public static void main(String[] args) {
        APITesting_Lab03_NP nbp = new APITesting_Lab03_NP();
        nbp.step1();
        nbp.step2();
        nbp.step3("Ruchi");
    }
}
