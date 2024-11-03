package client;

import java.util.Scanner;

public class ClientMain {

    public static void main(String args[]) {

        System.out.println("Hey this is the client!");
        String inputLocation = "";
        String outputLocation = "";

        System.out.println("Welcome to our Software Project");
        System.out.println("This program takes in an int N as a file, and then returns fibonacci to the Nth");
        System.out.println("You can choose to put this number in a file, or return it to the println");
        System.out.println("");

        // give me a filename thru scanner
        System.out.println("Input a csv file name. No need for the .csv extension");
        System.out.println("Each entry will be handled seperatly"); // WILL IT??? idk says pippin
        Scanner scanner = new Scanner(System.in);
        inputLocation = scanner.nextLine();

        System.out.println("Do you want to output to a file or print? F for file, P for print)");

        // WHY IS THIS NOT WORKING????
        while (true) {
            outputLocation = scanner.nextLine();

            if (outputLocation.equalsIgnoreCase("F")) {
                System.out.println("You Choose " + outputLocation);

                break;
            } else {
                System.out.println("Invalid input! Try again!");
                System.out.println("F for file, P for print");
            }
        }

        System.out.println("You choose to get the data from " + inputLocation);
        if (outputLocation.equalsIgnoreCase("F")) {
            System.out.println("You choose to print to a File!");
            // TODO Do something with the enums here
        }
        if (outputLocation == "P") {
            System.out.println("You choose to print to the Printline!");
            // TODO Do something with the enums here
        }
        scanner.close();
        // give that filename to the protobuff
        // Do the enum thing with the protobuf

        // send protobuff!

    }

}