import java.util.List;
import java.util.Arrays;
import apis.ce.InternalComputeEngine;
import placeholders.DatastorePlaceholder;



public class SRCIntegrationTest {

    public static void main(String[] args) {
        // Initializing template datastore
        placeholders.DatastorePlaceholder dataStore = new placeholders.DatastorePlaceholder();
        
        // Initializing internal compute engine with template datastore
        apis.ce.InternalComputeEngine computeEngine = new apis.ce.InternalComputeEngine(dataStore);

        // Initialize Coordinator with InternalComputeEngine
        apis.us.UScomputerEngineConstructer coordinator = new apis.us.UScomputerEngineConstructer(computeEngine);

        
        //Pippin's UScomputerEngineConstructor will use this function to add the data inputed to the user
        coordinator.setData();
        
        System.out.println("US: Data set to " + coordinator.getData());
        //This function tells the data inside coordinator (of type UScomputerEngineConstructor) to send the data
        coordinator.sendDataToComputeEngine();

      //--------------------------------------
        
        
        dataStore.storeData(computeEngine.computeNthFibonacci(computeEngine.getData()));
      
       


        // Retrieve data from DataStore
        int finalResult = dataStore.getStoredData();
        System.out.println("Integration Test: Final result in Data Store is " + finalResult);
    }
}
