package com.company;
import java.util.Scanner;

import static com.company.FractionSimplifier.simplify;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System. in);
        String inputString = scanner. nextLine();
        System.out.println(simplify(inputString));
    }
}
