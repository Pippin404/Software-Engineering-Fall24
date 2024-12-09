package apis.ce;

import apis.ds.DataStore;
import java.util.Map;
import java.util.HashMap;
import java.util.List;



public class InternalComputeEngine implements InternalComputeEngineInterface {

    // Placeholder Values
    private Integer data = null;
    private Map<Integer, Integer> memo = new HashMap<>();
    

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

	
   public int betterComputeNthFibonacci(int n) {
        validateData(n);
        
        // Expand array if needed
        while (n >= memoArray.length) {
            int[] newArray = new int[memoArray.length * 2];
            System.arraycopy(memoArray, 0, newArray, 0, memoArray.length);
            memoArray = newArray;
        }

        // If not computed yet, fill up to n
        for (int i = maxComputed + 1; i <= n; i++) {
            memoArray[i] = (i <= 1) ? i : memoArray[i-1] + memoArray[i-2];
        }
        maxComputed = Math.max(maxComputed, n);

        return memoArray[n];
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
