package client;

import java.util.Scanner;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import protobuf.Clientserver;
import protobuf.Clientserver.sendclientserver;
import protobuf.Clientserver.sendresponse;
import protobuf.SenddataGrpc;

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

    // SENDING PROTOBUF???
        //ASK: Send enum with correct location?
        //ASK: 
        
        
        
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext() // Disable TLS for simplicity
                .build();

        // Create a blocking stub
        SenddataGrpc.SenddataBlockingStub stub = SenddataGrpc.newBlockingStub(channel);

        // Build the request
        sendclientserver request = sendclientserver.newBuilder()
                .setFileLocation(inputLocation) // INPUT LOCATION GOES HERE!!
                .setOutputLocation(sendclientserver.outLocation.file) //THIS IS SETTING OUTPUTLOCATION TO FILE. HOW TO CHANGE IN IF STATEMENT??
                .build();

        try {
            // Make the RPC call and get the response
            //I AM DOING THIS ONE WRONG??
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

}