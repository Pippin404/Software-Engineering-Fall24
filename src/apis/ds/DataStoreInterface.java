package apis.ds;

public interface DataStoreInterface {

    FileParseResponse internalInputParse(FileParseRequest fileParseRequest);

    WriteListToFileResponse writeListToFile(WriteListToFileRequest writeListToFileRequest);

    WriteIntegerToFileResponse writeIntegerToFile(WriteIntegerToFileRequest writeIntegerToFileRequest);

    StartPrototypeResponse startPrototype(StartPrototypeRequest startPrototypeRequest);

}
