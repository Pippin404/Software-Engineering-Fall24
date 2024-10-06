package apis.ds;

import statuscodes.BasicResponseCode;
import statuscodes.ParseInputFileResponseCode;

import java.util.ArrayList;
import java.util.List;

public class ParseInputFileResponse {
//    should include the raw integers from the parsed file so the CE can access them
    List<Integer> parsedIntegers;
    ParseInputFileResponseCode parseInputFileResponseCode;
    BasicResponseCode basicResponseCode;

    public ParseInputFileResponse(List<Integer> parsedIntegers, ParseInputFileResponseCode parseInputFileResponseCode, BasicResponseCode basicResponseCode) {
        this.parsedIntegers = parsedIntegers;
        this.parseInputFileResponseCode = parseInputFileResponseCode;
        this.basicResponseCode = basicResponseCode;
    }

    public List<Integer> getParsedIntegers() {
        return parsedIntegers;
    }

    public ParseInputFileResponseCode getParseInputFileResponseCode() {
        return parseInputFileResponseCode;
    }

    public BasicResponseCode getBasicResponseCode() {
        return basicResponseCode;
    }
}
