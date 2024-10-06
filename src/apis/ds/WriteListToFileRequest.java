package apis.ds;

import inputoutput.OutputConfig;
import statuscodes.ParameterResponseCode;

import java.util.List;

public class WriteListToFileRequest {
    private OutputConfig outputConfig;

    private List<Integer> parsedIntegerList;

    private ParameterResponseCode parameterResponseCode;


    public WriteListToFileRequest(OutputConfig outputConfig, List<Integer> parsedIntegerList) {
        try {
            if(outputConfig != null) {
                this.outputConfig = outputConfig;
            } else {
                parameterResponseCode = ParameterResponseCode.NULL_PARAMETER;
                throw new IllegalArgumentException("Output config cannot be null.");
            }

            if(outputConfig != null) {
                this.parsedIntegerList = parsedIntegerList;
            } else {
                parameterResponseCode = ParameterResponseCode.NULL_PARAMETER;
                throw new IllegalArgumentException("List of integers cannot be null.");
            }
            parameterResponseCode = ParameterResponseCode.VALID_PARAMETERS;

        } catch(IllegalArgumentException e) {
            e.printStackTrace();
        }

    }

    public OutputConfig getOutputConfig() {
        return outputConfig;
    }

    public List<Integer> getParsedIntegerList() {
        return parsedIntegerList;
    }

    public ParameterResponseCode getBasicResponseCode() {
        return parameterResponseCode;
    }
}
