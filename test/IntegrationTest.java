package test;

import griffinapi.InternalComputeReadingInterface;
import griffinapi.InternalComputeReading;
import griffinapi.InternalComputeEngineInterface;
import griffinapi.InternalComputeEngine;
import test_utils.TestInputConfig;
import test_utils.TestOutputConfig;
import test_utils.TestDataStore;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

public class IntegrationTest {

    @Test
    public void testComputeEngineIntegration() {
        List<Integer> inputData = Arrays.asList(1, 10, 25);

        TestInputConfig inputConfig = new TestInputConfig(inputData);
        TestOutputConfig outputConfig = new TestOutputConfig();

        TestDataStore dataStore = new TestDataStore(inputConfig, outputConfig);

        InternalComputeReadingInterface reader = new InternalComputeReading();

        InternalComputeEngineInterface engine = new InternalComputeEngine(reader);

        for (Integer input : dataStore.readInputData()) {
            reader.setData(input);

            int result = engine.compute(0); // The parameter is not used in compute()

            dataStore.writeOutputData(String.valueOf(result));
        }

        // Expected outputs for Fibonacci of [1, 10, 25]
        List<String> expectedOutput = Arrays.asList("1", "55", "75025");

        List<String> actualOutput = outputConfig.getOutputData();

        assertEquals("Output data does not match expected results", expectedOutput, actualOutput);
    }
}
