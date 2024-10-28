import apis.ds.DataStore;
import apis.ce.InternalComputeEngine;
import apis.us.UScomputerEngineConstructer;

import java.io.File;
import java.util.List;


public class SRCIntegrationTest {


    public static void main(String[] args) {
        
        // Path to the file (update the path as needed)
        File inputFile = new File("test/testInputFile.test");
        
        // Initializing datastore
        DataStore dataStore = new DataStore();

        // Initializing internal compute engine
        InternalComputeEngine computeEngine = new InternalComputeEngine();

        // Initialize Coordinator with InternalComputeEngine and DataStore
        UScomputerEngineConstructer coordinator = new UScomputerEngineConstructer(computeEngine, dataStore);

        
        // Set the input file in the coordinator
        coordinator.setInputFile(inputFile);

        coordinator.setData();  // This reads from the file and sets the data
        System.out.println("US: Data set to " + coordinator.getData());


      //--------------------------------------
        

        dataStore.setData((coordinator.runInternalCompute(coordinator.getData())));
              
       


        // Retrieve data from DataStore
        List<Integer> finalResult = dataStore.getData();
        System.out.println("Integration Test: Final result in Data Store is " + finalResult);
    }
}
