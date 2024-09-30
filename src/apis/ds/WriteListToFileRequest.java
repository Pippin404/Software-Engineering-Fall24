package apis.ds;

import inputoutput.OutputConfig;

import java.util.List;

public class WriteListToFileRequest {
    private final OutputConfig outputConfig;

    private final List<Integer> parsedIntegerList;

    public WriteListToFileRequest(OutputConfig outputConfig, List<Integer> parsedIntegerList) {
        this.outputConfig = outputConfig;
        this.parsedIntegerList = parsedIntegerList;
    }

    public OutputConfig getOutputConfig() {
        return outputConfig;
    }

    public List<Integer> getParsedIntegerList() {
        return parsedIntegerList;
    }
}
