package apis.ce;

import apis.ds.DataStore;

public class InternalComputeEngine implements InternalComputeEngineInterface {

    // Placeholder Values
    private Integer data = null;
    @SuppressWarnings("unused")
    private DataStore dataStore;

    public InternalComputeEngine(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    
    //this was given to me by eclipse. I think it removes the "unused" error. Pippin assignment 4
    @SuppressWarnings("unused")
    private String message = null;


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

    @Override
    public void validateData(Integer i) {
        if (i == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("Data cannot be negative");
        }
    }


}
