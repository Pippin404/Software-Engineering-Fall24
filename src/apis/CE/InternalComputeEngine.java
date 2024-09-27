package apis.CE;

public class InternalComputeEngine implements InternalComputeEngineInterface {

    // Placeholder Values
    private Integer data = null;
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

}
