import apis.ds.DataStore;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import apis.ce.InternalComputeEngine;
import apis.us.UScomputerEngineConstructer;


public class SRCIntegrationTest {


    public static void main(String[] args) {
        
        // Create a File object for the test input file
        File inputFile = new File("test/testInputFile.test");
        
        System.out.println("Calling thread");
        callThread(inputFile);


        
        //TODO: Run the below code. then make it run on a single thread
        //TODO: run the below code on 3 threads. 
        
    }
    
    
    public synchronized static void useAPIs(File inputFile) {
        //TODO Make this a thread!! Make it run on it!!!
        // Initializing template datastore
        DataStore dataStore = new DataStore();

        // Initializing internal compute engine with template datastore
        InternalComputeEngine computeEngine = new InternalComputeEngine(dataStore);

        // Initialize Coordinator with InternalComputeEngine
        UScomputerEngineConstructer coordinator = new UScomputerEngineConstructer(computeEngine);

        // Set the input file in coordinator
        coordinator.setInputFile(inputFile);
        
        //Pippin's UScomputerEngineConstructor will use this function to add the data inputed to the user
        coordinator.setData();
        
        System.out.println("US: Data set to " + coordinator.getData());
        //This function tells the data inside coordinator (of type UScomputerEngineConstructor) to send the data
        coordinator.sendDataToComputeEngine();

      //--------------------------------------
        
        
        dataStore.setData(computeEngine.computeNthFibonacci(computeEngine.getData()));
      
       


        // Retrieve data from DataStore
        int finalResult = dataStore.getData();
        System.out.println("Integration Test: Final result in Data Store is " + dataStore.getData());
    }
    
    
    public static void callThread(File inputFile) {
        Callable<Void> test = () ->{
            
            System.out.println("A thread was called to use the APIS!!");
            useAPIs(inputFile);
            return null;
        };
        
        ExecutorService threadPool = Executors.newCachedThreadPool();
        
        
        int numThreads=3;
            //Prof's solution to this
            List<Future<?>> futures = new ArrayList<>();
            for (int i = 0; i < numThreads; i++) {
                Future<Void> resultOfPlayer = threadPool.submit(test);
                futures.add(resultOfPlayer);
            }
            
            for (Future<?> future : futures) {
                try {
                    future.get();
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            
        
    }
    
    
}
