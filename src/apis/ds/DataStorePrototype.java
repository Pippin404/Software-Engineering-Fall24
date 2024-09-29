package apis.ds;

public class DataStorePrototype {
    public static void prototypeCode(DataStore dataStore) {

//        start this process
        StartPrototypeResponse startPrototype = dataStore.startPrototype(new StartPrototypeRequest());

//        parse the input file into raw integers
        ParseInputFileResponse parseInputFile = dataStore.parseInputFile(new ParseInputFileRequest(null, null, null));

//        write those integers into the output file
        WriteToFileResponse writeToFileResponse = dataStore.writeIntegerToFile(new WriteToFileRequest());

    }
}
