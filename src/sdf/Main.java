package sdf;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    //Write a program to add, remove and list contents of a shopping cart.
    //List, add and delete
    public static void main(String[] args) {
        
        Console cons = System.console();
        System.out.println("Welcome to your shopping cart");
        String input = "";
        List<String> cartItems = new ArrayList<String>();

        while (!input.equalsIgnoreCase("quit")) {
            input = cons.readLine("What do you want to do? ");

            if (input.equalsIgnoreCase("list")) {
                
                if (cartItems.size() > 0) {
                    for (int i = 0; i < cartItems.size(); i++) {
                        System.out.printf("%d. %s\n", i+1, cartItems.get(i));
                    }
                } else {
                    System.out.println("Your cart is empty");
                }
            }

            if (input.startsWith("add")) {
                input = input.replace(',', ' ');

                String stringVal = "";
                Scanner scan = new Scanner(input.substring(4));

                while(scan.hasNext()) {
                    stringVal = scan.next();
                    // System.out.printf("%s\n", stringVal);

                    if (cartItems.contains(stringVal)) {
                        System.out.println("Item already exists");
                    } else {
                        cartItems.add(stringVal);
                    }
                }
            }

            if (input.startsWith("delete")) {
                Scanner scan = new Scanner(input.substring(7));

                String stringVal = "";
                while(scan.hasNext()) {

                    stringVal = scan.next();

                    if (Integer.parseInt(stringVal) > cartItems.size()) { 
                        System.out.println("Incorrect item index");
                    } else {
                        System.out.printf("%s removed from cart\n", cartItems.get(Integer.parseInt(stringVal) - 1));
                        cartItems.remove(Integer.parseInt(stringVal));
                    }
                }
            }

        }
        System.out.println("Goodbye");

    }
}
