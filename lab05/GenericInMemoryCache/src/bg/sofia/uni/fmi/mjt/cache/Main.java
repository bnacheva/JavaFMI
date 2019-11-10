package bg.sofia.uni.fmi.mjt.cache;

import bg.sofia.uni.fmi.mjt.cache.implementations.LeastFrequentlyUsed;
import bg.sofia.uni.fmi.mjt.cache.implementations.RandomReplacement;
import bg.sofia.uni.fmi.mjt.cache.interfaces.Cache;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long capacity = scanner.nextLong();
        Cache<Integer, String> leastFrequentlyUsed = new LeastFrequentlyUsed();
        Cache<Integer, String> randomReplacement = new RandomReplacement();
    }
}
