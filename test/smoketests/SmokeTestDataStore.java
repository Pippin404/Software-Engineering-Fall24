package smoketests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import apis.ds.DataStore;
import apis.ds.DataStorePrototype;
import apis.ds.WriteToFileRequest;
import apis.ds.ParseInputFileRequest;

import static org.mockito.Mockito.mock;

public class SmokeTestDataStore {

    private static DataStore DataStore;
    private apis.ds.ChooseDefaultDelimitersRequest chooseDefaultDelimitersRequest;
    private Class<? extends ParseInputFileRequest> sendSourceRequest;


    @Test
    public void dataStoreTest() {
        DataStore mockDataStore = mock(DataStore.class);

        DataStorePrototype dataStorePrototype = new DataStorePrototype();
        DataStorePrototype.prototypeCode(mockDataStore);
        Assertions.assertEquals(mockDataStore, null);
    }

    @Test
    public void chooseDelimitersTest() {
        ChooseDefaultDelimitersRequest mockChooseDelimitersRequest = mock(ChooseDefaultDelimitersRequest.class);

        DataStore.chooseDelimiters(mockChooseDelimitersRequest);
        Assertions.assertEquals(DataStore, null);
    }

    @Test
    public void sendSourceTest() {
        ParseInputFileRequest mockParseInputFileRequest = mock(ParseInputFileRequest.class);

        DataStore.sendInput(mockParseInputFileRequest);
        Assertions.assertEquals(DataStore, null);
    }

    @Test
    public void sendDestinationTest() {
        WriteToFileRequest mockWriteToFileRequest = mock(WriteToFileRequest.class);

        DataStore.sendDestination(mockWriteToFileRequest);
        Assertions.assertEquals(DataStore, null);
    }

    @Test
    public void getDelimiterTypeTest() {

        DataStore.getDelimiterType();
        Assertions.assertEquals(DataStore, null);
    }

    @Test
    public void sendDelimitersTest() {
        SendDelimitersRequest mockSendDelimitersRequest = mock(SendDelimitersRequest.class);

        DataStore.sendDelimiters(mockSendDelimitersRequest);
        Assertions.assertEquals(DataStore, null);
    }



}

