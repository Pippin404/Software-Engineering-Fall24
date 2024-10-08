import java.util.List;
import java.util.Arrays;
import testutils.Coordinator;
import ce.InternalComputeEngineTest;
import ds.DataStore;



public class IntegrationTest {

    public static void main(String[] args) {
        // Start by Initializing DataStore 
        ds.DataStore dataStore = new ds.DataStore();

        // Initialize InternalComputeEngineTest with DataStore
        ce.InternalComputeEngineTest computeEngine = new ce.InternalComputeEngineTest(dataStore);

        // Initialize Coordinator with InternalComputeEngine
        Coordinator coordinator = new Coordinator(computeEngine);

        // Set data in Coordinator
        List<Integer> dataList = Arrays.asList(1, 10, 25);
        coordinator.setData(dataList);
        System.out.println("Coordinator: Data set to " + dataList);

        // Start the data flow
        coordinator.sendDataToComputeEngine();

        // Retrieve data from DataStore
        int finalResult = dataStore.getStoredData();
        System.out.println("Integration Test: Final result in Data Store is " + finalResult);
    }
}
