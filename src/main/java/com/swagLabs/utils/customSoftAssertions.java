package com.swagLabs.utils;

import org.testng.asserts.SoftAssert;

public class customSoftAssertions extends SoftAssert {


    public static customSoftAssertions softAssertions = new customSoftAssertions();

    public static void softAssertAll() {

        try {
            softAssertions.assertAll("Soft Assertion Error");
        } catch (Exception e) {
            System.out.println("Soft Assertion Error: " + e.getMessage());
        }
    }

}