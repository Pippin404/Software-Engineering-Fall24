package apis.ds;

public interface DataStoreInterface {

    FileParseResponse internalParseInput(FileParseRequest fileParseRequest);

    WriteListToFileResponse writeListToFile(WriteListToFileRequest writeListToFileRequest);

    InternalWriteIntegerResponse internalWriteInteger(InternalWriteIntegerRequest internalWriteIntegerRequest);

    StartPrototypeResponse startPrototype(StartPrototypeRequest startPrototypeRequest);

}
