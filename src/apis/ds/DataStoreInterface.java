package apis.ds;

public interface DataStoreInterface {

    ParseInputFileResponse parseInputFile(ParseInputFileRequest parseInputFileRequest);

    WriteListToFileResponse writeListToFile(WriteListToFileRequest writeListToFileRequest);

    WriteIntegerToFileResponse writeIntegerToFile(WriteIntegerToFileRequest writeIntegerToFileRequest);

    StartPrototypeResponse startPrototype(StartPrototypeRequest startPrototypeRequest);

}
