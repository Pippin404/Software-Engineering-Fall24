package client;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.StatusRuntimeException;
import protobuf.Clientserver.sendclientserver;
import protobuf.Clientserver.sendresponse;
import protobuf.SenddataGrpc;
import server.ClientServer;

public class ClientMain {
    public static void main(String[] args) {
        Server clientServer = null;
        ManagedChannel clientChannel = null;
        Scanner scanner = new Scanner(System.in);
        try {
            // Start ClientServer on a known port (e.g., 50051)
            clientServer = ServerBuilder.forPort(50051)
                .addService(new ClientServer()) // ClientServer will create Coordinator, which starts ParseFile server
                .build()
                .start();
            System.out.println("ClientServer started on port 50051");

            // Connect to the ClientServer
            clientChannel = ManagedChannelBuilder.forAddress("localhost", 50051)
                    .usePlaintext()
                    .build();

            SenddataGrpc.SenddataBlockingStub stub = SenddataGrpc.newBlockingStub(clientChannel);

            System.out.println("Hey this is the client!");
            String inputLocation = "";
            String outputLocation = "";
            String outputPath = "";
            
            System.out.println("Welcome to our Software Project");
            System.out.println("This program takes in a list of integers in file form and returns the computed fibonacci value of each.");
            System.out.println("You can choose to output the computed numbers into an existing .csv file or print the output to the console.");
            System.out.println("");
            
            
            
            // Verifies if file exists
            while (true) {
                // give me a filename thru scanner
                System.out.println("In the console enter the the path from your current directory to your file.");
                System.out.println("The file should be a list of integers in a comma separated list, like this: X,Y,Z");
                System.out.println("Each entry will be handled seperatly."); 
                System.out.println("Current Directory: " + System.getProperty("user.dir"));
                inputLocation = scanner.nextLine();
                inputLocation.toString();

                // NEED TO TEST THIS
                boolean alreadyExists = true;
                try {
                    alreadyExists = new File(inputLocation).createNewFile();// SHOULD BE FALSE
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if (alreadyExists == false) {
                    System.out.println("File accepted!");
                    break;
                } else {
                    System.out.println("File NOT accepted! please try again");

                }
            }
            

           
            // Ask user whether to output to file or print
            System.out.println("Do you want to output to a file or print? (F for file, P for print)");
            while (true) {
                outputLocation = scanner.nextLine();
                if (outputLocation.equalsIgnoreCase("F")) {
                    System.out.println("You chose file output!");
                    break;
                } else if (outputLocation.equalsIgnoreCase("P")) {
                    System.out.println("You chose print output!");
                    break;
                } else {
                    System.out.println("Invalid input! Try again!");
                    System.out.println("F for file, P for print");
                }
            }

            // If user chose file output, ask for the output file path
            if (outputLocation.equalsIgnoreCase("F")) {
                System.out.println("Enter the path to the .csv file you want to output to:");
                outputPath = scanner.nextLine();
            } else {
                System.out.println("You chose to print to the console!");
            }

            // Build the gRPC request
            sendclientserver.Builder builder = sendclientserver.newBuilder();
            builder.setFileLocation(inputLocation);
            if (outputLocation.equalsIgnoreCase("F")) {
                builder.setOutputLocation(sendclientserver.outLocation.file);
                builder.setOutputPath(outputPath);
            } else {
                builder.setOutputLocation(sendclientserver.outLocation.print);
            }

            sendclientserver request = builder.build();
            System.out.println("Request: " + request);

            // Send the request to ClientServer
            try {
                sendresponse response = stub.senddatatoclient(request);
                System.out.println("Response: " + response.getMessage());
            } catch (StatusRuntimeException e) {
                System.out.println("RPC failed: " + e.getStatus());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            if (clientChannel != null) {
                clientChannel.shutdownNow();
                try {
                    clientChannel.awaitTermination(5, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (clientServer != null) {
                clientServer.shutdownNow();
                try {
                    clientServer.awaitTermination(5, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

