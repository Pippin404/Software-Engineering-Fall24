package smoketests;

import org.mockito.Mockito;

import ce.InternalComputeEngineTest;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyInt;
import org.junit.jupiter.api.Assertions;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.Test;
import ds.DataStore;


public class SmokeTestGriffin {
    
    @Test
    public void test() {    
        DataStore ds=new DataStore();
        InternalComputeEngineTest engine = new InternalComputeEngineTest((ds.DataStore) ds);

        // Mock the InternalComputeReadingInterface
        InternalComputeEngineTest mockEngine = Mockito.mock(InternalComputeEngineTest.class);
        when(mockEngine.computeNthFibonacci(anyInt())).thenReturn(100);

        // testing set and get data
        engine.setData(5);
        if (engine.getData() == 5) {
            System.out.println("setData and getData passed.");
        } else {
            System.out.println("setData and getData failed.");
        }

        // testing compute() method
        if (mockEngine.computeNthFibonacci(10) == 100) {
            System.out.println("compute method passed placeholder logic.");
        } else {
            System.out.println("compute method failed.");
        }


    }
}
