package test_utils;

import java.util.List;

public class TestDataStore {
    private TestInputConfig inputConfig;
    private TestOutputConfig outputConfig;

    public TestDataStore(TestInputConfig inputConfig, TestOutputConfig outputConfig) {
        this.inputConfig = inputConfig;
        this.outputConfig = outputConfig;
    }

    public List<Integer> readInputData() {
        return inputConfig.getInputData();
    }

    public void writeOutputData(String data) {
        outputConfig.addOutput(data);
    }
}
