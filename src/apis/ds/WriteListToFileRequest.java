package apis.ds;

import java.util.List;

public class WriteListToFileRequest {
    private final OutputConfig OUTPUT_CONFIG;

    private final List<Integer> parsedIntegerList;

    public WriteListToFileRequest(OutputConfig OUTPUT_CONFIG, List<Integer> parsedIntegerList) {
        this.OUTPUT_CONFIG = OUTPUT_CONFIG;
        this.parsedIntegerList = parsedIntegerList;
    }

    public OutputConfig getOUTPUT_CONFIG() {
        return OUTPUT_CONFIG;
    }

    public List<Integer> getParsedIntegerList() {
        return parsedIntegerList;
    }
}
