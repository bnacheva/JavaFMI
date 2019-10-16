package com.company;

import java.util.ArrayList;
import java.util.List;

public class WordAnalyzer {
    public static String getSharedLetters(String word1, String word2) {
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();
        String result = "";
        int indexWord1 = 0;
        boolean[] visitedWord1 = new boolean[26];
        int indexWord2 = 0;
        boolean[] visitedWord2 = new boolean[26];
        for (int i = 0; i < word1.length(); i++) {
            if ('a' <= word1.charAt(i) && word1.charAt(i) <= 'z') {
                indexWord1 = word1.charAt(i) - 'a';
            }
            visitedWord1[indexWord1] = true;
        }
        for (int i = 0; i < word2.length(); i++) {
            if ('a' <= word2.charAt(i) && word2.charAt(i) <= 'z') {
                indexWord2 = word2.charAt(i) - 'a';
            }
            visitedWord2[indexWord2] = true;
        }
        List toInt = new ArrayList();
        for (int i = 0; i < 26; i++) {
            if (visitedWord1[i] && visitedWord2[i]) {
                toInt.add(i);
            }
        }
        for (int i = 0; i < toInt.size(); i++) {
            var digit = toInt.get(i);
            result += convertToLetter((int)digit);
        }
        return result == "" ? "" : result.toLowerCase();
    }

    public static char convertToLetter(int digit) {
        for (int i = 0; i < 26; i++) {
            if (digit == i) {
                digit = (char)(digit + 65);
            }
        }
        return (char)digit;
    }
}
