package ds.integrationtests;

import apis.ds.DataStore;
import apis.ds.FileParseRequest;
import apis.ds.FileParseResponse;
import apis.ds.InternalWriteIntegerRequest;
import inputoutput.Delimiter;
import inputoutput.InputType;
import inputoutput.OutputConfig;
import inputoutput.OutputType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class NewImplementationTests {

    private DataStore dataStore = new DataStore();

    private static final String VALID_INPUT_FILE_PATH = "test/ds/iotests/csvTest.txt";
    private static final File VALID_INPUT_FILE = new File(VALID_INPUT_FILE_PATH);

    private Delimiter validDelimiter = Delimiter.COMMA;
    private InputType validInputType = InputType.CSV;

    FileParseRequest request = FileParseRequest.builder()
            .delimiter(validDelimiter)
            .inputFile(VALID_INPUT_FILE)
            .inputType(validInputType)
            .build();

    private static final String VALID_OUTPUT_FILE_PATH = "test/ds/iotests/test.txt";

    InternalWriteIntegerRequest writeRequest = InternalWriteIntegerRequest.builder()
            .outputPath(VALID_OUTPUT_FILE_PATH)
            .outputType(OutputType.TEXT)
            .computedInteger(5)
            .build();

    @BeforeEach
    void setUp() {
        validDelimiter = Delimiter.COMMA;
        validInputType = InputType.CSV;
    }

    public static void main(String[] args) throws FileNotFoundException {
    }

    @Test
    public void parseCSVTest() {
        FileParseResponse response = dataStore.internalParseInput(request);

        List<Integer> parsedResult = response.getParsedIntegers();

        List<Integer> expectedResult = new ArrayList<Integer>(
          Arrays.asList(1, 2, 3, 4, 5)
        );
        Assertions.assertEquals(parsedResult, expectedResult);

        System.out.println(parsedResult);

    }
    @Test
    public void writeToFileTest() throws FileNotFoundException {

        dataStore.internalWriteInteger(writeRequest);

        File file = new File(VALID_OUTPUT_FILE_PATH);
        Scanner myReader = new Scanner(file);

//        check that it was written to the file
        String data = "";
        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
            System.out.println(data);
        }
        myReader.close();
        assertEquals(data, "5");

    }
}


