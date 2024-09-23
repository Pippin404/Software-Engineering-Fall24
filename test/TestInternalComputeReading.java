package test;

import griffinapi.InternalComputeReadingInterface;
import griffinapi.InternalComputeReading;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestInternalComputeReading {

    private InternalComputeReadingInterface reader;

    @Before
    public void setUp() {
        reader = new InternalComputeReading();
    }

    @Test
    public void testSetDataAndGetData() {
        reader.setData(10);
        int data = reader.getData();
        assertEquals("Data should be 10", 10, data);
    }

    @Test
    public void testReadInData() {
        int result = reader.readInData("5");
        assertEquals("Result should be 0 as per placeholder implementation", 0, result);
    }
}
