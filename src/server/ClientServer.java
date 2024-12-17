package server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import protobuf.Clientserver.sendclientserver;
import protobuf.Clientserver.sendresponse;
import protobuf.SenddataGrpc;
import apis.ce.InternalComputeEngine;
import apis.ds.DataStore;
import apis.us.UScomputerEngineConstructer;


import java.io.File;
import java.io.IOException;
import java.util.List;

public class ClientServer extends SenddataGrpc.SenddataImplBase {

  public static void main(String[] args) throws IOException, InterruptedException {
      // Start the gRPC server
        Server server = ServerBuilder.forPort(50051)
                .addService(new ClientServer())
                .build()
                .start();

        System.out.println("Server started on port 50051");

        // Keep the server running
        server.awaitTermination();
  }


  @Override
  // follows the pattern outlined in the senddatatoclient method that was generated from proto (SenddataGrpc.java)
  public void senddatatoclient(sendclientserver request, StreamObserver<sendresponse> responseObserver) {
  
    String fileLocation = request.getFileLocation();
    sendclientserver.outLocation outputLocation = request.getOutputLocation();
    String outputPath = request.getOutputPath();

    // Initialize necessary components (DataStore, InternalComputeEngine, etc.)
    DataStore dataStore = new DataStore();
    InternalComputeEngine computeEngine = new InternalComputeEngine();
    UScomputerEngineConstructer coordinator = new UScomputerEngineConstructer(computeEngine, dataStore);

    
    // Set up the input file and process it
    File inputFile = new File(fileLocation);
    coordinator.setInputFile(inputFile);   
    coordinator.setData();
    
   
    List<Integer> result1 = coordinator.runInternalCompute(coordinator.getData());
    
    dataStore.setData(result1);

    

    
    if (outputLocation == sendclientserver.outLocation.print) {
        System.out.println("Computed Results: " + result1);
    } else {
        coordinator.writeComputedResultsToFile(result1, outputPath);
    }
    System.out.println(outputPath);
    
    
    // Create and send a response
    sendresponse response = sendresponse.newBuilder()
                        // Need to add other responses for errors
            .setMessage("File accepted. Output Type: "+ outputLocation +".")
            .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();

    
  }

  

}
