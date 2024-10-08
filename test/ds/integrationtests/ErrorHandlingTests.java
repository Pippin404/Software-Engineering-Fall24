package ds.integrationtests;


import apis.ds.DataStore;
import apis.ds.ParseInputFileRequest;
import apis.ds.ParseInputFileResponse;
import apis.ds.WriteIntegerToFileRequest;
import inputoutput.InputConfig;
import inputoutput.InputType;
import inputoutput.OutputConfig;
import inputoutput.OutputType;
import inputoutput.Delimiter;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.io.FileNotFoundException;

public class ErrorHandlingTests {
    public static void main(String[] args) {
//        I'm not sure how to use junit to test this so I'm just using main for now
        DataStore dataStore = new DataStore();
        OutputConfig outputConfig = new OutputConfig("C:\\Users\\eribr\\Desktop\\Software Engineering\\Software-Engineering-Fall24\\test\\ds\\iotests\\OutputText.txt", OutputType.TEXT);
        WriteIntegerToFileRequest writeIntegerToFileRequest = new WriteIntegerToFileRequest(outputConfig, 5);

        dataStore.writeIntegerToFile(writeIntegerToFileRequest);

    }
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
