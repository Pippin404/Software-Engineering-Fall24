package ds.integrationtests;

import apis.ds.DataStore;
import apis.ds.ParseInputFileRequest;
import apis.ds.ParseInputFileResponse;
import inputoutput.Delimiter;
import inputoutput.InputConfig;
import inputoutput.InputType;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class ErrorHandlingTests {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void parseFileWithInvalidPath() {
        DataStore dataStore = new DataStore();
        ParseInputFileRequest parseInputFileRequest = new ParseInputFileRequest(new InputConfig(new File("wombo"), InputType.CSV), Delimiter.COMMA);

        exception.expect(FileNotFoundException.class);

//        ParseInputFileResponse response = dataStore.parseInputFile(parseInputFileRequest);
//
//        List<Integer> parsedIntegers = response.getParsedIntegers();
//        System.out.println(parsedIntegers);

    }

    @Test
    public void parseFileWithValidPath() {
//        Test should fail as it should not trigger the exception
        DataStore dataStore = new DataStore();
        ParseInputFileRequest parseInputFileRequest = new ParseInputFileRequest(new InputConfig(new File("test/ds/iotests/csvTest.txt"), InputType.CSV), Delimiter.COMMA);



        ParseInputFileResponse response = dataStore.parseInputFile(parseInputFileRequest);

        Assert.assertNotNull(response.getParsedIntegers());
//        List<Integer> parsedIntegers = response.getParsedIntegers();
//        System.out.println(parsedIntegers);

    }


}
