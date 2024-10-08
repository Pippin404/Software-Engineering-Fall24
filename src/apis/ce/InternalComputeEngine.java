package apis.ce;

import apis.ds.DataStore;

public class InternalComputeEngine implements InternalComputeEngineInterface {

    // Placeholder Values
    private Integer data = null;
    @SuppressWarnings("unused") 
    private DataStore dataStore;

    public InternalComputeEngine(DataStore dataStore) {
    if (dataStore == null) {
        throw new IllegalArgumentException("DataStore cannot be null");
    }
    this.dataStore = dataStore;
    }


    @Override
    public void setData(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Data cannot be negative");
        } 
	data = i;
    }

    @Override
    public int getData() {
    if (this.data < 0) {
        throw new IllegalArgumentException("Data cannot be negative");
    }
    return 0;
    }
	
    @Override
    public int computeNthFibonacci(int i) {
	if (i < 0) {
            throw new IllegalArgumentException("Data cannot be negative");
        }
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
