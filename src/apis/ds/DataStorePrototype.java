package apis.ds;

public class DataStorePrototype {
    public static void prototypeCode(DataStoreInterface dataStoreInterface) {

//        start this process
        StartPrototypeResponse startPrototype = dataStoreInterface.startPrototype(new StartPrototypeRequest());

//        parse the input file into raw integers
        ParseInputFileResponse parseInputFile = dataStoreInterface.parseInputFile(new ParseInputFileRequest(null, null));

//        write those integers into the output file
        WriteListToFileResponse writeListToFileResponse = dataStoreInterface.writeListToFile(new WriteListToFileRequest(null, null));

    }
}
