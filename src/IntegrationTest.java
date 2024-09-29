import java.util.List;
import java.util.Arrays;
import apis.ce.InternalComputeEngine;
import placeholders.DatastorePlaceholder;
import placeholders.CoordinatorPlaceholder;



public class IntegrationTest {

    public static void main(String[] args) {
        // Initializing template datastore
        placeholder.DatastorePlaceholder dataStore = new placeholder.DatastorePlaceholder();
        
        // Initializing internal compute engine with template datastore
        apis.ce.InternalComputeEngine computeEngine = new apis.ce.InternalComputeEngine(dataStore);

        // Initialize Coordinator with InternalComputeEngine
        placeholder.CoordinatorPlaceholder coordinator = new placeholder.CoordinatorPlaceholder(computeEngine);

        int data = 10;
        coordinator.setData(data);
        System.out.println("Coordinator: Data set to " + data);

        coordinator.sendDataToComputeEngine();

        // Retrieve data from DataStore
        int finalResult = dataStore.getStoredData();
        System.out.println("Integration Test: Final result in Data Store is " + finalResult);
    }
}
