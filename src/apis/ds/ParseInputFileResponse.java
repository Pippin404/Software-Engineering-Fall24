package apis.ds;

import statuscodes.BasicResponseCode;
import statuscodes.FileResponseCode;

import java.util.List;

public class ParseInputFileResponse {
//    should include the raw integers from the parsed file so the CE can access them
    List<Integer> parsedIntegers;
    FileResponseCode fileResponseCode;
    BasicResponseCode basicResponseCode;

    public ParseInputFileResponse(List<Integer> parsedIntegers, FileResponseCode fileResponseCode, BasicResponseCode basicResponseCode) {
        this.parsedIntegers = parsedIntegers;
        this.fileResponseCode = fileResponseCode;
        this.basicResponseCode = basicResponseCode;
    }

    public List<Integer> getParsedIntegers() {
        return parsedIntegers;
    }

    public FileResponseCode getParseInputFileResponseCode() {
        return fileResponseCode;
    }

    public BasicResponseCode getBasicResponseCode() {
        return basicResponseCode;
    }
}
