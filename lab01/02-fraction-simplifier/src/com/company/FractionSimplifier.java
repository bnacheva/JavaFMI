package com.company;

public class FractionSimplifier {
    public static String simplify(String fraction) {
        String[] parts = fraction.split("/");
        int numerator = Integer.parseInt(parts[0]);
        int denominator = Integer.parseInt(parts[1]);
        return reduce(numerator, denominator);
    }

    public static int calculateGCD(int numerator, int denominator) {
        if (numerator % denominator == 0) {
            return denominator;
        }
        return calculateGCD(denominator, numerator % denominator);
    }

    public static String reduce(int numerator, int denominator) {
        String result = "";
        int gcd = calculateGCD(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        if (denominator != 1) {
            result += numerator + "/" + denominator;
        }
        else {
            result += numerator;
        }
        return result;
    }
}
