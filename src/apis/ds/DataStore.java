package apis.ds;

public interface DataStore {

    ParseInputFileResponse parseInputFile(ParseInputFileRequest parseInputFileRequest);

    WriteToFileResponse writeIntegerToFile(WriteToFileRequest writeToFileRequest);

    StartPrototypeResponse startPrototype(StartPrototypeRequest startPrototypeRequest);
    //im just trying to get this to pass gradle :Pippin, 9/27/24 2:30pm
}
