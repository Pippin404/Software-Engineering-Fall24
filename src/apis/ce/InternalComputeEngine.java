package apis.ce;

import apis.ds.DataStore;

public class InternalComputeEngine implements InternalComputeEngineInterface {

    // Placeholder Values
    private Integer data = null;
    private DataStore dataStore;

    public InternalComputeEngine(DataStore dataStore) {
        this.dataStore = dataStore;
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
    	int firstfib = 0;
    	int secondfib = 1;
    	while (i != 0) {
	    int placeholder = firstfib;
	    firstfib = secondfib;
            secondfib = placeholder + secondfib;
            i--;
    	}
	return firstfib;
    }


}
