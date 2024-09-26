package griffinapi;

import static org.mockito.Mockito.*;

public class SmokeTestGriffin {
    public static void main(String[] args) {
        
        InternalComputeEngine engine = new InternalComputeEngine();

        // Mock the InternalComputeReadingInterface
        InternalComputeEngine mockEngine = Mockito.mock(InternalComputeEngine.class);
        when(mockEngine.readInData(any(String())).thenReturn(100));
        when(mockEngine.compute(any(Integer())).thenReturn(100));

        // testing set and get data
        engine.setData(5);
        if (engine.getData() == 5) {
            System.out.println("setData and getData passed.");
        } else {
            System.out.println("setData and getData failed.");
        }

        // testing compute() method
        if (mockEngine.compute(10) == 100) {
            System.out.println("compute method passed placeholder logic.");
        } else {
            System.out.println("compute method failed.");
        }


        // Smoke test for readInData
        if (mockEngine.readInData("test") == 100) {
            System.out.println("readInData method passed with mock.");
        } else {
            System.out.println("readInData method failed with mock.");
        }

        // Verify the mock method was called
        verify(mockEngine).readInData("test");
    }
}
