public class InternalComputeEngine implements ComputeEngineInterface {

    // Placeholder Values
    private Integer data = null;
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
    public int compute(int i) {
        return 1;

    }


}
