package apis.us;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

import apis.ce.InternalComputeEngine;
import apis.ds.DataStore;
import apis.ds.FileParseRequest;
import apis.ds.FileParseResponse;
import inputoutput.InputConfig;
import inputoutput.InputType;
import inputoutput.Delimiter;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import protobuf.datastore.ParseFileGrpc;
import protobuf.datastore.ParseFileGrpc.ParseFileBlockingStub;
import protobuf.datastore.ParseInputFile.ParseFileServiceResponse;
import protobuf.datastore.ParseInputFile.ParseFileServiceRequest;
import protobuf.datastore.WriteIntegerGrpc;
import protobuf.datastore.WriteIntegerGrpc.WriteIntegerBlockingStub;


public class UScomputerEngineConstructer {

    private final Channel channel;
    private final ParseFileBlockingStub parseFileStub;
    private final WriteIntegerBlockingStub writeIntegerStub;
    //Make an "InternalComputeEngine" to pass the data to the CE
        private InternalComputeEngine computeEngine;
        private DataStore dataStore;
        private UserCommunicatorImpl commHandler=null;
        private List<Integer> data;
        private File inputFile;  // Store the file as a file object
        private final ExecutorService threadPool;
        private static final int MAX_THREADS = 3;  // Define upper limit for threads


        public UScomputerEngineConstructer(InternalComputeEngine computeEngine, DataStore dataStore) {
        if (dataStore == null || computeEngine == null) {
           throw new IllegalArgumentException("Data cannot be null");
        }
        this.computeEngine=computeEngine;
        //Keeping this dataStore so it doesn't break everything else that uses this class
        this.dataStore = dataStore;    
        this.threadPool = Executors.newFixedThreadPool(MAX_THREADS); // Initialize fixed thread pool

            //gRPC channel for the DataStoreServer
            //TODO: This probably shouldn't be hardcoded like this
            this.channel = ManagedChannelBuilder.forAddress("localhost", 50052)
                    //TODO: PlainText probably shouldn't be used
                    .usePlaintext()
                    .build();
            this.parseFileStub = ParseFileGrpc.newBlockingStub(channel);
            this.writeIntegerStub = WriteIntegerGrpc.newBlockingStub(channel);
        }

        public void setInputFile(File file) {
            this.inputFile = file;
            System.out.println("Reading data from: " + this.inputFile.getName()); 
            // ^ conformation message for file setting (remove if you want)
        }

        // get method for file
        public File getInputFile() {
            return this.inputFile;
        }


        public void setData() {
            
            if(this.commHandler==null) {
                this.commHandler=new UserCommunicatorImpl();
            }

            // Create a ServiceRequest for the DataStoreServer
                //InputConfig inputConfig = new InputConfig(inputFile, InputType.CSV);
                //Delimiter delimiter = Delimiter.COMMA;
                //FileParseRequest request = new FileParseRequest(inputConfig, delimiter);

                //TODO: InputType is hardcoded to be CSV
            ParseFileServiceRequest request = ParseFileServiceRequest.newBuilder()
                    .setInputFile(inputFile.getAbsolutePath())
                    .setInputType(protobuf.datastore.CommonEnums.InputOutputType.CSV)
                    .setDelimiter(protobuf.datastore.CommonEnums.ExternalDelimiter.COMMA)
                    .build();

            // Send the request to the server
            // This parses the file using DataStore
                //FileParseResponse response = dataStore.internalParseInput(request);
            ParseFileServiceResponse response = parseFileStub.parseInputFileService(request);

            // Default to [1, 2, 3] if the file is empty
            if (response.getParsedIntegersList().isEmpty()) {
                data = Arrays.asList(1, 2, 3);
            } else {
                data = response.getParsedIntegersList();
            }

            System.out.println("Numbers read from file in coordinator: " + data);
        }

        public List<Integer> getData() {
            return data;
        }
        
        // single thread
        public List<Integer> runInternalCompute(List<Integer> numbers) {
            List<Integer> results = new ArrayList<>();
            for (int number : numbers) {
                int result = computeEngine.computeNthFibonacci(number);
                results.add(result);
            }
            return results;
        }

        
        // multithreaded
        public List<Integer> runInternalComputeWithThreading(List<Integer> numbers) {
                List<Future<Integer>> futures = new ArrayList<>();
                List<Integer> results = new ArrayList<>();
        
                for (int number : numbers) {
                    Callable<Integer> task = () -> computeEngine.computeNthFibonacci(number);
                    futures.add(threadPool.submit(task));
                }
        
                for (Future<Integer> future : futures) {
                    try {
                        results.add(future.get());  // Wait for each task to complete and collect result
                    } catch (InterruptedException | ExecutionException e) {
                        System.out.println("Error in computation thread: " + e.getMessage());
                        e.printStackTrace();
                    }
                }
        return results;
        }


        public void shutdownThreadPool() {
                threadPool.shutdown();  // Shutdown thread pool after computations
        }





        
}
