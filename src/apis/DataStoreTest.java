package apis;

import apis.data_store.DataStorePrototype;
import apis.data_store.DataStore;
import org.mockito.Mockito;




public class DataStoreTest {
    private static final DataStorePrototype dataStoreAPI = new DataStorePrototype();


    public static void main(String[] args) {
        DataStore mockInput = Mockito.mock(DataStore.class);
        prototype(mockInput);
    }

    static void prototype(DataStore dataStore){
//        not sure if this is how I'm supposed to do it
        DataStoreTest.dataStoreAPI.prototypeCode(dataStore);
    }
}
