package apis.ds;

import java.util.ArrayList;
import java.util.List;

public class ParseInputFileResponse {
//    should include the raw integers from the parsed file so the CE can access them
    List<Integer> parsedIntegers = new ArrayList<>();

    public ParseInputFileResponse(List<Integer> parsedIntegers) {
        this.parsedIntegers = parsedIntegers;
    }

    public List<Integer> getParsedIntegers() {
        return parsedIntegers;
    }
}
