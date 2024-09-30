package apis.ds;

import inputoutput.OutputConfig;

import java.util.List;

public class WriteIntegerToFileRequest {
    private final OutputConfig OUTPUT_CONFIG;

    private final int computedInteger;

    public WriteIntegerToFileRequest(OutputConfig OUTPUT_CONFIG, int computedInteger) {
        this.OUTPUT_CONFIG = OUTPUT_CONFIG;
        this.computedInteger = computedInteger;
    }

    public OutputConfig getOUTPUT_CONFIG() {
        return OUTPUT_CONFIG;
    }

    public int getComputedInteger() {
        return computedInteger;
    }
}
