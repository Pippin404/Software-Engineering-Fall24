package apis.ds;

import inputoutput.OutputConfig;
import statuscodes.ParameterResponseCode;

public class WriteIntegerToFileRequest {
    private OutputConfig outputConfig;

    private int computedInteger;

    private ParameterResponseCode parameterResponseCode;

    public WriteIntegerToFileRequest(OutputConfig outputConfig, int computedInteger) {
        try {
            if (outputConfig == null) {
                parameterResponseCode = ParameterResponseCode.NULL_PARAMETER;
                throw new IllegalArgumentException("Output config cannot be null.");
            } else {
                this.outputConfig = outputConfig;
            }

//            don't check for computedInteger being null because the compiler won't let someone put null for a primitive int in a parameter to begin with

            parameterResponseCode = ParameterResponseCode.VALID_PARAMETERS;

        } catch(IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public OutputConfig getOutputConfig() {
        return outputConfig;
    }

    public int getComputedInteger() {
        return computedInteger;
    }

    public ParameterResponseCode getParameterResponseCode() {
        return parameterResponseCode;
    }
}
