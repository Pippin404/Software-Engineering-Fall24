package DS;

import org.mockito.Mockito;

import apis.ds.DataStore;
import apis.ds.DataStorePrototype;




public class DataStoreTest {
    private static final DataStorePrototype dataStorePrototype = new DataStorePrototype();


    public static void main(String[] args) {
        DataStore mockInput = Mockito.mock(DataStore.class);
        prototype(mockInput);
    }

    static void prototype(DataStore dataStore){
//        not sure if this is how I'm supposed to do it
        DataStorePrototype.prototypeCode(dataStore);
    }
}
