import java.util.List;
import java.util.Arrays;
import apis.ce.InternalComputeEngine;
import placeholders.DatastorePlaceholder;
import placeholders.CoordinatorPlaceholder;



public class SRCIntegrationTest {

    public static void main(String[] args) {
        // Initializing template datastore
        placeholders.DatastorePlaceholder dataStore = new placeholders.DatastorePlaceholder();
        
        // Initializing internal compute engine with template datastore
        apis.ce.InternalComputeEngine computeEngine = new apis.ce.InternalComputeEngine(dataStore);

        // Initialize Coordinator with InternalComputeEngine
        placeholders.CoordinatorPlaceholder coordinator = new placeholders.CoordinatorPlaceholder(computeEngine);

        int data = 10;
        coordinator.setData(data);
        System.out.println("Coordinator: Data set to " + data);

        coordinator.sendDataToComputeEngine();
        dataStore.storeData(computeEngine.computeNthFibonacci(computeEngine(getdata()));

        // Retrieve data from DataStore
        int finalResult = dataStore.getStoredData();
        System.out.println("Integration Test: Final result in Data Store is " + finalResult);
    }
}
