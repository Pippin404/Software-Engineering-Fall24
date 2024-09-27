package smoketests;

import org.mockito.Mockito;

import testutils.InternalComputeEngine;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyInt;
import org.junit.jupiter.api.Assertions;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.Test;


public class SmokeTestGriffin {
    
    @Test
    public void test() {    
        InternalComputeEngineTest engine = new InternalComputeEngineTest();

        // Mock the InternalComputeReadingInterface
        InternalComputeEngineTest mockEngine = Mockito.mock(InternalComputeEngineTest.class);
        when(mockEngine.readInData(anyString())).thenReturn(100);
        when(mockEngine.compute(anyInt())).thenReturn(100);

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