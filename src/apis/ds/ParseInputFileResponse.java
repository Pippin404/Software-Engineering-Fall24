package apis.ds;

import statuscodes.ParameterResponseCode;
import statuscodes.FileResponseCode;

import java.util.List;

public class ParseInputFileResponse {
//    should include the raw integers from the parsed file so the CE can access them
    List<Integer> parsedIntegers;
    FileResponseCode fileResponseCode;
    ParameterResponseCode parameterResponseCode;

    public ParseInputFileResponse(List<Integer> parsedIntegers, FileResponseCode fileResponseCode, ParameterResponseCode parameterResponseCode) {
        this.parsedIntegers = parsedIntegers;
        this.fileResponseCode = fileResponseCode;
        this.parameterResponseCode = parameterResponseCode;
    }

    public List<Integer> getParsedIntegers() {
        return parsedIntegers;
    }

    public FileResponseCode getParseInputFileResponseCode() {
        return fileResponseCode;
    }

    public ParameterResponseCode getBasicResponseCode() {
        return parameterResponseCode;
    }
}
