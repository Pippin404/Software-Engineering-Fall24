package apis.ds;

import inputoutput.OutputConfig;
import statuscodes.BasicResponseCode;

import java.util.List;

public class WriteListToFileRequest {
    private OutputConfig outputConfig;

    private List<Integer> parsedIntegerList;

    private BasicResponseCode basicResponseCode;


    public WriteListToFileRequest(OutputConfig outputConfig, List<Integer> parsedIntegerList) {
        try {
            if(outputConfig != null) {
                this.outputConfig = outputConfig;
            } else {
                basicResponseCode = BasicResponseCode.NULL_PARAMETER;
                throw new IllegalArgumentException("Output config cannot be null.");
            }

            if(outputConfig != null) {
                this.parsedIntegerList = parsedIntegerList;
            } else {
                basicResponseCode = BasicResponseCode.NULL_PARAMETER;
                throw new IllegalArgumentException("List of integers cannot be null.");
            }
            basicResponseCode = BasicResponseCode.VALID_PARAMETERS;

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

    public BasicResponseCode getBasicResponseCode() {
        return basicResponseCode;
    }
}
