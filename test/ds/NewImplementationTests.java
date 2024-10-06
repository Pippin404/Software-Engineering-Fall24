package ds;


import apis.ds.ParseInputFileRequest;
import apis.ds.ParseInputFileResponse;
import apis.ds.WriteIntegerToFileRequest;
import apis.ds.DataStore;
import inputoutput.Delimiter;
import inputoutput.InputType;
import inputoutput.OutputConfig;
import inputoutput.OutputType;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class NewImplementationTests {
    public static void main(String[] args) throws FileNotFoundException {
    }

    @Test
    public void parseCSVTest() {
        DataStore ds = new DataStore();

        File inputFile = new File("D:\\New Desktop on Hard drive\\Software Engineering\\Software-Engineering-Fall24\\test\\ds\\csvTest.txt");
        ParseInputFileRequest request = new ParseInputFileRequest(inputFile, InputType.CSV, Delimiter.COMMA);

        ParseInputFileResponse response = ds.parseInputFile(request);

        List<Integer> parsedResult = response.getParsedIntegers();

        List<Integer> expectedResult = new ArrayList<Integer>(
          Arrays.asList(1, 2, 3, 4, 5)
        );
        assertEquals(parsedResult, expectedResult);

        System.out.println(parsedResult);

    }
    @Test
    public void writeToFileTest() throws FileNotFoundException {
        DataStore ds = new DataStore();

        OutputConfig outputConfig = new OutputConfig("D:\\New Desktop on Hard drive\\Software Engineering\\Software-Engineering-Fall24\\test\\ds\\test.txt", OutputType.TEXT);

        WriteIntegerToFileRequest request = new WriteIntegerToFileRequest(outputConfig, 5);

        ds.writeIntegerToFile(request);

        File file = new File(outputConfig.getOutputPath());
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

