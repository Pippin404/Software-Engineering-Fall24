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
import apis.ds.ParseInputFileRequest;
import apis.ds.ParseInputFileResponse;
import inputoutput.InputConfig;
import inputoutput.InputType;
import inputoutput.Delimiter;


public class UScomputerEngineConstructer {

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
        this.dataStore = dataStore;    
        this.threadPool = Executors.newFixedThreadPool(MAX_THREADS); // Initialize fixed thread pool
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


        //  TODO: That is a crazy solution to a null pointer problem we should not do this lmao
        public void setData() {
            
            if(this.commHandler==null) {
                this.commHandler=new UserCommunicatorImpl();
            }



            // Create InputConfig and ParseInputFileRequest for DataStore
            InputConfig inputConfig = new InputConfig(inputFile, InputType.CSV);
            Delimiter delimiter = Delimiter.COMMA;
            ParseInputFileRequest request = new ParseInputFileRequest(inputConfig, delimiter);

            // Parse the file using DataStore
            ParseInputFileResponse response = dataStore.parseInputFile(request);
            data = response.getParsedIntegers();
            System.out.println("Numbers read from file in coordinator: " + data);
            
            
            // Default to [1, 2, 3] if the file is empty
            if (data.isEmpty()) {
                data = Arrays.asList(1, 2, 3);
            }

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
