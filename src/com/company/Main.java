package com.company;

import java.util.Scanner;

public class Main {

    /**
     * Scanner to read input from the console
     **/
    public static final Scanner SCANNER = new Scanner(System.in);


    public static void main(String[] args) {
	// write your code here

        System.out.println("Hello! What is your name?");
        String username = SCANNER.nextLine();
        System.out.println("Hello there " + username + "!");

    }
}
