package apis.ds;

public interface DataStoreInterface {

    FileParseResponse internalParseInput(FileParseRequest fileParseRequest);

    WriteListToFileResponse writeListToFile(WriteListToFileRequest writeListToFileRequest);

    WriteIntegerResponse internalWriteInteger(WriteIntegerRequest writeIntegerRequest);

    StartPrototypeResponse startPrototype(StartPrototypeRequest startPrototypeRequest);

}
