package apis.ce;

import placeholders;
import java.util.List;

public class InternalComputeEngine implements InternalComputeEngineInterface {

    // Placeholder Values
    private Integer data = null;
    private DatastorePlaceholder dataStore;

    
    //this was given to me by eclipse. I think it removes the "unused" error
    @SuppressWarnings("unused")
    private String message = null;

    
	
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
