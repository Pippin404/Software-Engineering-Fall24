import apis.ds.DataStore;
import apis.ce.InternalComputeEngine;
import apis.us.UScomputerEngineConstructer;


public class SRCIntegrationTest {


    public static void main(String[] args) {
        // Initializing datastore
        DataStore dataStore = new DataStore();

        // Initializing internal compute engine
        InternalComputeEngine computeEngine = new InternalComputeEngine();

        // Initialize Coordinator with InternalComputeEngine and DataStore
        UScomputerEngineConstructer coordinator = new UScomputerEngineConstructer(computeEngine, dataStore);

        
        //Pippin's UScomputerEngineConstructor will use this function to add the data inputed to the user
        coordinator.setData();
        
        System.out.println("US: Data set to " + coordinator.getData());
        //This function tells the data inside coordinator (of type UScomputerEngineConstructor) to send the data
        coordinator.sendDataToComputeEngine();

      //--------------------------------------
        

        dataStore.setData((coordinator.runInternalCompute()));
              
       


        // Retrieve data from DataStore
        int finalResult = dataStore.getData();
        System.out.println("Integration Test: Final result in Data Store is " + finalResult);
    }
}
