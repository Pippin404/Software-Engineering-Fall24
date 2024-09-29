import java.util.List;
import java.util.Arrays;
import testutils.Coordinator;
import apis.ce.InternalComputeEngine;
import placeholder.datastoreplaceholder;
import placeholder.coordinatorplaceholder;



public class IntegrationTest {

    public static void main(String[] args) {
        // Initializing template datastore
        placeholder.datastoreplaceholder dataStore = new placeholder.datastoreplaceholder();
        // Initializing internal compute engine with template datastore
        apis.ce.InternalComputeEngine computeEngine = new apis.ce.InternalComputeEngine(dataStore);
        //HEY THIS LINE HAD A PARAMETER DATASTORE! I REMOVED IT BECAUSE ITS NOT IN THE CONSTRUCTOR!!^^^^

        // Initialize Coordinator with InternalComputeEngine
        placeholder.coordinatorplaceholder coordinator = new placeholder.coordinatorplaceholder(computeEngine);

        int data = 10;
        coordinator.setData(data);
        System.out.println("Coordinator: Data set to " + data);

        coordinator.sendDataToComputeEngine();

        // Retrieve data from DataStore
        int finalResult = dataStore.getStoredData();
        System.out.println("Integration Test: Final result in Data Store is " + finalResult);
    }
}
