package apis.ce;

import java.util.List;

public class InternalComputeEngine implements InternalComputeEngineInterface {

    // Placeholder Values
    private Integer data = null;
    
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
    public int compute(int i) {
        // Need to implement fib. here
	return 1;

    }

    public void receiveData(List<Integer> data2) {
        // TODO Auto-generated method stub
        //This is from the coordinator under test/testutils. Idk if it was supposed to do this or not
        //-Pippin: 9/27/24 2:27pm
    }

}