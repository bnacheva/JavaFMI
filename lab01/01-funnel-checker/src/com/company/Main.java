package com.company;
import java.util.*;
import static com.company.FunnelChecker.isFunnel;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System. in);
        String inputString1 = scanner. nextLine();
        String inputString2 = scanner. nextLine();
	    System.out.println(isFunnel(inputString1, inputString2));
    }
}
