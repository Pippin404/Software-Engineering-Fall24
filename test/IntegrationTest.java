package griffinapi;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

import test_utils.TestDataStore;
import test_utils.TestInputConfig;
import test_utils.TestOutputConfig;

public class ComputeEngineIntegrationTest {

    @Test
    public void testComputeEngineWithDataStore() {
        TestInputConfig inputConfig = new TestInputConfig(Arrays.asList(1, 10, 25));

        TestOutputConfig outputConfig = new TestOutputConfig();

        TestDataStore dataStore = new TestDataStore(inputConfig, outputConfig);

        InternalComputeEngine engine = new InternalComputeEngine();
        
        engine.setDataStore(dataStore);

        List<Integer> inputData = dataStore.readInputData();
        for (Integer input : inputData) {
            engine.setData(input);
            int result = engine.compute(input);
            String output = "ComputedValue" + result;
            dataStore.writeOutputData(output);
        }

        List<String> expectedOutput = Arrays.asList("ComputedValue1", "ComputedValue1", "ComputedValue1");
        assertEquals(expectedOutput, outputConfig.getOutputData());
    }
}
