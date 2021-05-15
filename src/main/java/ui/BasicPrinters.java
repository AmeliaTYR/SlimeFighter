package main.java.ui;

import java.util.Scanner;

public class BasicPrinters {
    public static String command = "";

    /**
     * Scanner to read input from the console
     **/
    public static final Scanner SCANNER = new Scanner(System.in);


    public static void main(String[] args) {
        // write your code here

        System.out.println("Hello! What is your name?");
        String username = SCANNER.nextLine();
        System.out.println("Hello there " + username + "! Give a command!");


        while (true){
            command = SCANNER.nextLine();

            if (command.equals("greet")){
                System.out.println("Hello again username!");
            }
            else if (command.equals("joke")){
                System.out.println("I have no jokes lmao");
            } else if (command.equals("exit") || command.equals("bye")) {
                System.out.println("Bye!");
                break;
            } else {
                System.out.println("I don't understand the command?");
            }
        }

    }

}

