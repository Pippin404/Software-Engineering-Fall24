package apis.ds;

import inputoutput.OutputConfig;

public class WriteIntegerToFileRequest {
    private final OutputConfig outputConfig;

    private final int computedInteger;


    public WriteIntegerToFileRequest(OutputConfig outputConfig, int computedInteger) {
        this.outputConfig = outputConfig;
        this.computedInteger = computedInteger;
    }

    public OutputConfig getOutputConfig() {
        return outputConfig;
    }

    public int getComputedInteger() {
        return computedInteger;
    }
}
