package smoketests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import apis.ce.InternalComputeEngine;
import apis.ds.DataStore;
import apis.us.UScomputerEngineConstructer;

public class SmokeTestIntegration {

    
    
    
    @Test
    public void mainTests() {
     // Initializing template datastore
        DataStore dataStore = new DataStore();

        
        // Initializing internal compute engine with template datastore
        InternalComputeEngine computeEngine = new InternalComputeEngine(dataStore);
        //should get 0, because there is no data yet
        Assertions.assertEquals(computeEngine.getData(),0);
        
        
        
        // Initialize Coordinator with InternalComputeEngine
        UScomputerEngineConstructer coordinator = new UScomputerEngineConstructer(computeEngine);
        
        
        
        
        //Pippin's UScomputerEngineConstructor will use this function to add the data inputed to the user
        coordinator.setData();
        Assertions.assertEquals(coordinator.getData(),5); //HEY THIS IS TEMP BTW
        
        System.out.println("US: Data set to " + coordinator.getData());
        //This function tells the data inside coordinator (of type UScomputerEngineConstructor) to send the data
        coordinator.setData();
        
        //why did we think the variable computeEngine INSIDE UScomputerEngineConstructor had the actual compute engine class???
        
        dataStore.setData(computeEngine.computeNthFibonacci(coordinator.getData()));

        // Retrieve data from DataStore
        int finalResult = dataStore.getData();
        System.out.println("Integration Test: Final result in Data Store is " + finalResult);
    }
}