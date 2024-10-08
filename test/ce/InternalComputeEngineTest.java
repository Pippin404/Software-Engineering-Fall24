package ce;

import java.util.List;

import apis.ce.InternalComputeEngineInterface;
import ds.DataStore;


public class InternalComputeEngineTest implements InternalComputeEngineInterface {

    // Placeholder Values
    private Integer data = null;
    @SuppressWarnings("unused")
    private String message = null;
    private DataStore dataStore;
    
    public InternalComputeEngineTest(DataStore dataStore) {
        this.dataStore = dataStore;
    }
	
    public void receiveData(List<Integer> dataList) {
        System.out.println("Compute Engine: Received data from Coordinator.");
	      // Example computation
	      int result = 100;
        sendDataToDataStore(result);
    }

    private void sendDataToDataStore(int result) {
        System.out.println("Compute Engine: Sending result to Data Store.");
        dataStore.storeData(result);
    }



    @Override
    public void setData(int i) {
       data = i;
    }

    @Override
    public int getData() {
	      if (data != null) {
            return data;
        }
    return 0;
    }

    @Override
    public int computeNthFibonacci(int i) {
	return 1;
    }

}
