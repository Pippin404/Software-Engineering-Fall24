package test;

import griffinapi.InternalComputeEngineInterface;
import griffinapi.InternalComputeEngine;
import griffinapi.InternalComputeReadingInterface;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestInternalComputeEngine {

    private InternalComputeEngineInterface computeEngine;
    private InternalComputeReadingInterface mockReader;

    @Before
    public void setUp() {
        // Create a mock of InternalComputeReadingInterface
        mockReader = Mockito.mock(InternalComputeReadingInterface.class);

        // Define mock behavior
        when(mockReader.getData()).thenReturn(5);

        // Initialize computeEngine with the mocked reader
        computeEngine = new InternalComputeEngine(mockReader);
    }

    @Test
    public void testComputeWithMockReader() {
        // Call the compute method
        int result = computeEngine.compute(0); // Parameter is not used in the placeholder

        // Verify that getData was called on the mock
        verify(mockReader).getData();

        // Assert the expected result
        assertEquals("Compute method should return 1 as per placeholder", 1, result);
    }
}
