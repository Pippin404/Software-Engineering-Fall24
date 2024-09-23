package griffinapi;

public class InternalComputeEngine implements InternalComputeEngineInterface {

    // Placeholder Values
    private Integer data = null;
    private String message = null;
    private InternalComputeReadingInterface reader;

    // Constructor accepting the reader dependency
    public InternalComputeEngine(InternalComputeReadingInterface reader) {
        this.reader = reader;
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
