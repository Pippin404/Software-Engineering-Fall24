package apis.ce;

import apis.ds.DataStore;
import java.util.Map;
import java.util.HashMap;
import java.util.List;


public class InternalComputeEngine implements InternalComputeEngineInterface {

    // Placeholder Values
    private Integer data = null;
    private int[] memoArray = new int[25];
    private int maxComputed = 1; 

        

    
    
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
