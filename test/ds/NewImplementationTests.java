package ds;


import apis.ds.DataStore;
import apis.ds.WriteIntegerToFileRequest;
import inputoutput.OutputConfig;
import inputoutput.OutputType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NewImplementationTests {


    @Test
    public void setDataTest() {
        DataStore dataStore = new DataStore();
        dataStore.setData(5);
        assertEquals(dataStore.getData(), 5);
    }

    @Test
    public void writeToFileTest() {
        DataStore dataStore = new DataStore();
        OutputConfig outputConfig = new OutputConfig("C:\\Users\\eribr\\Desktop\\Software Engineering\\Software-Engineering-Fall24\\test\\ds\\OutputText.txt", OutputType.TEXT);
        WriteIntegerToFileRequest request = new WriteIntegerToFileRequest(outputConfig, 5);

        dataStore.writeIntegerToFile(request);
    }

}


