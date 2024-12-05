package client;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import protobuf.Clientserver.sendclientserver;
import protobuf.Clientserver.sendresponse;
import protobuf.SenddataGrpc;

public class ClientMain {
    public static void main(String args[]) {

        System.out.println("Hey this is the client!");
        String inputLocation = "";
        String outputLocation = "";
        String outputPath = "";

        System.out.println("Welcome to our Software Project");
        System.out.println("This program takes in an int N as a file, and then returns fibonacci to the Nth");
        System.out.println("You can choose to put this number in a file, or return it to the println");
        System.out.println("");

        Scanner scanner = new Scanner(System.in);

        // Verifies if file exists
        while (true) {
            // give me a filename thru scanner
            System.out.println("Input a csv file name. No need for the .csv extension. Remember to use capitals?");
            System.out.println("Each entry will be handled seperatly"); // WILL IT??? idk says pippin
            inputLocation = scanner.nextLine();
            inputLocation.toString();

            // NEED TO TEST THIS
            boolean Alreadyexists = true;
            try {
                Alreadyexists = new File(inputLocation).createNewFile();// SHOULD BE FALSE
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (Alreadyexists == false) {
                System.out.println("File accepted!");
                break;
            } else {
                System.out.println("File NOT accepted! please try again");

            }
        }

        System.out.println("Do you want to output to a file or print? F for file, P for print)");

        // WHY IS THIS NOT WORKING????
        while (true) {
            outputLocation = scanner.nextLine();

            if (outputLocation.equalsIgnoreCase("F")) {
                System.out.println("You Choose " + outputLocation + ", File!");
                break;

            } else if (outputLocation.equalsIgnoreCase("P")) {
                System.out.println("You Choose " + outputLocation + ", print!");
                break;

            } else {
                System.out.println("Invalid input! Try again!");
                System.out.println("F for file, P for print");
            }
        }

        System.out.println("You choose to get the data from " + inputLocation);
        if (outputLocation.equalsIgnoreCase("F")) {
            System.out.println("You choose to print to a File!");
            System.out.println("Enter the output file path:");
            outputPath = scanner.nextLine();
        } else if (outputLocation.equalsIgnoreCase("P")) {
            System.out.println("You choose to print to the Printline!");
            // TODO Do something with the enums here
        }
        scanner.close();
        // give that filename to the protobuff
        // Do the enum thing with the protobuf

        // send protobuff!

        // SENDING PROTOBUF???

        // ASK: Send enum with correct location? HOW TO?
        // ASK:

        // CHECK FOR REAL FILENAME

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext() // Disable TLS for
                                                                                                     // simplicity
                .build();

        // Create a blocking stub
        SenddataGrpc.SenddataBlockingStub stub = SenddataGrpc.newBlockingStub(channel);

        // Build the request DO AN IF STATEMENT?? FOR ENUM MAYBE

        sendclientserver.Builder builder = sendclientserver.newBuilder();
        builder.setFileLocation(inputLocation);
        // INPUT LOCATION GOES
        if (outputLocation.equalsIgnoreCase("F")) {
            builder.setOutputLocation(sendclientserver.outLocation.file);
            builder.setOutputPath(outputPath);
            // do like a print for bugtesting
        } else {
            builder.setOutputLocation(sendclientserver.outLocation.print);
        }

        sendclientserver request = builder.build();
        System.out.println(request); // this is cool

        try {
            // Make the RPC call and get the response
            // I AM DOING THIS ONE WRONG??
            sendresponse response = stub.senddatatoclient(request);
            System.out.println("Response: " + response.getMessage());
        } catch (StatusRuntimeException e) {
            System.out.println("RPC failed: " + e.getStatus());
        } finally {
            // Shutdown the channel
            channel.shutdown();
        }
    }

}
