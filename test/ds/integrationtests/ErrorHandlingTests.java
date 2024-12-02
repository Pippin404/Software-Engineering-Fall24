package ds.integrationtests;


import apis.ds.FileParseRequest;
import apis.ds.FileParseResponse;
import apis.ds.InternalWriteIntegerRequest;
import inputoutput.InputConfig;
import inputoutput.InputType;
import inputoutput.OutputConfig;
import inputoutput.OutputType;
import inputoutput.Delimiter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

public class ErrorHandlingTests {
    public static void main(String[] args) {
//        I'm not sure how to use junit to test this so I'm just using main for now
        DataStore dataStore = new DataStore();
        OutputConfig outputConfig = new OutputConfig("C:\\Users\\eribr\\Desktop\\Software Engineering\\Software-Engineering-Fall24\\test\\ds\\iotests\\OutputText.txt", OutputType.TEXT);
        InternalWriteIntegerRequest internalWriteIntegerRequest = new InternalWriteIntegerRequest(outputConfig, 5);

        dataStore.internalWriteInteger(internalWriteIntegerRequest);

    }

    @Test
    public void parseFileWithInvalidPath() {
        DataStore dataStore = new DataStore();
        FileParseRequest fileParseRequest = new FileParseRequest(new InputConfig(new File("wombo"), InputType.CSV), Delimiter.COMMA);

        Assertions.assertThrows(FileNotFoundException.class);

//        ParseInputFileResponse response = dataStore.parseInputFile(parseInputFileRequest);
//
//        List<Integer> parsedIntegers = response.getParsedIntegers();
//        System.out.println(parsedIntegers);

    }

    @Test
    public void parseFileWithValidPath() {
//        Test should fail as it should not trigger the exception
        DataStore dataStore = new DataStore();
        FileParseRequest fileParseRequest = new FileParseRequest(new InputConfig(new File("test/ds/iotests/csvTest.txt"), InputType.CSV), Delimiter.COMMA);



        FileParseResponse response = dataStore.internalParseInput(fileParseRequest);

        Assertions.assertNotNull(response.getParsedIntegers());
//        List<Integer> parsedIntegers = response.getParsedIntegers();
//        System.out.println(parsedIntegers);

    }


}
