package apis.ds;

public interface DataStore {

    ParseInputFileResponse parseInputFile(ParseInputFileRequest parseInputFileRequest);

    WriteListToFileResponse writeListToFile(WriteListToFileRequest writeListToFileRequest);

    WriteIntegerToFileResponse writeIntegerToFile(WriteIntegerToFileRequest writeIntegerToFileRequest);

    StartPrototypeResponse startPrototype(StartPrototypeRequest startPrototypeRequest);

}
