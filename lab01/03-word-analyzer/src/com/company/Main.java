package com.company;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.Scanner;
import static com.company.WordAnalyzer.getSharedLetters;

public class Main {

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System. in);
        //String inputString1 = scanner. nextLine();
        //String inputString2 = scanner. nextLine();
        //System.out.println(getSharedLetters(inputString1, inputString2));

        Result result = JUnitCore.runClasses(WordAnalyzerTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
