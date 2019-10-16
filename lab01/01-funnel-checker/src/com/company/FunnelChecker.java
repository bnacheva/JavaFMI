package com.company;

public class FunnelChecker {
    public static boolean isFunnel(String str1, String str2) {
        int counter = 0;
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) != -1) {
                counter ++;
            }
        }
        if (counter == str1.length() - 1) {
            return true;
        }
        return false;
    }
}
