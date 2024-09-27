package test_utils;
import griffinapi

public class InternalComputeEngine implements InternalComputeEngineInterface {

    // Placeholder Values
    private Integer data = null;
    private String message = null;
    private DataStore dataStore;

    public void receiveData(List<Integer> dataList) {
        System.out.println("Compute Engine: Received data from Coordinator.");
        int result = 0;
        
        // Send result to DataStore
        sendDataToDataStore(result);
    }
    
	

    @Override
    public int readInData(String i) {
    return 0;
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
    public int compute(int i) {
        // Need to implement fib. here
	return 1;

    }


}
