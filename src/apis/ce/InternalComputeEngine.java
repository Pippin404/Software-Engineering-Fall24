package apis.ce;

import apis.ds.DataStore;

public class InternalComputeEngine implements InternalComputeEngineInterface {

    // Placeholder Values
    private Integer data = null;
    

    @Override
    public void setData(int i) {
        validateData(i);
        data = i;
    }

    @Override
        public int getData() {
        validateData(this.data);
    return 0;
    }

    //TODO Assignment 8: see if anything can be factored out of the while loop
    @Override
    public int computeNthFibonacci(int i) {
	validateData(i);
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


    private void validateData(Integer i) {
        if (i == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("Data cannot be negative");
        }
    }


}
