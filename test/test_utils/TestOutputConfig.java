package test_utils;

import java.util.ArrayList;
import java.util.List;

public class TestOutputConfig {
    private List<String> outputData;

    public TestOutputConfig() {
        this.outputData = new ArrayList<>();
    }

    public void addOutput(String data) {
        outputData.add(data);
    }

    public List<String> getOutputData() {
        return outputData;
    }
}
