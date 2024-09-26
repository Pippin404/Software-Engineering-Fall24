package griffinapi;

import static org.mockito.Mockito.*;

public class SmokeTestGriffin {
    public static void main(String[] args) {
        InternalComputeEngine engine = new InternalComputeEngine();

        // testing set and get data
        engine.setData(5);
        if (engine.getData() == 5) {
            System.out.println("setData and getData passed.");
        } else {
            System.out.println("setData and getData failed.");
        }

        // testing compute() method
        if (engine.compute(10) == 1) {
            System.out.println("compute method passed (placeholder logic).");
        } else {
            System.out.println("compute method failed.");
        }

        // Mock the InternalComputeReadingInterface
        InternalComputeReadingInterface mockReader = mock(InternalComputeReadingInterface.class);
        when(mockReader.readData(anyString())).thenReturn(42);
        engine.setReader(mockReader);

        // Smoke test for readInData
        if (engine.readInData("test") == 42) {
            System.out.println("readInData method passed with mock.");
        } else {
            System.out.println("readInData method failed with mock.");
        }

        // Verify the mock method was called
        verify(mockReader).readData("test");
    }
}
