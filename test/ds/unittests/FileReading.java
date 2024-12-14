package ds.unittests;

import java.io.File;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import apis.ds.FileParseRequest;
import inputoutput.Delimiter;
import inputoutput.InputConfig;
import inputoutput.InputType;

public class FileReading {

    @Test
    public void invalidDelimiter() {
//        mock everything else to just test putting in a null InputConfig
        File mockInputFile = Mockito.mock(File.class);
        InputType mockInputType = Mockito.mock(InputType.class);
//        FileParseRequest fileParseRequest = new FileParseRequest(mockInputConfig, null);

        try {
            FileParseRequest fileParseRequest = FileParseRequest.builder().inputFile(mockInputFile)
                    .inputType(mockInputType).delimiter(null).build();
        } catch (Exception e) {

            System.out.println("Yay an error was found!");

        }
        // throws if not equal

        // System.out.println(fileParseRequest.getDelimiter());
        // Assertions.assertEquals(fileParseRequest.getDelimiter(), null);

    }

    @Test
    public void invalidInputType() {
        Delimiter delimiter = Mockito.mock(Delimiter.class);
        File mockInputFile = Mockito.mock(File.class);

        try {
            FileParseRequest fileParseRequest = FileParseRequest.builder().inputType(null).delimiter(delimiter)
                    .inputFile(mockInputFile).build();
        } catch (Exception e) {

            System.out.print("Yay invalidInputType caught an error");
        }
        // throws if not equal
        // Assertions.assertEquals(fileParseRequest, null);
    }

    @Test
    public void invalidFileTest() {
        // TODO: This should be testing builder logic now
//        mock everything but the input file in InputConfig, have it be a fake file
//        inputConfig isn't mocked because i'm testing the constructor for it
        File inputFile = new File("wobungus/blungus");
        InputType mockInputType = Mockito.mock(InputType.class);
        InputConfig inputConfig = new InputConfig(inputFile, mockInputType);

        Assertions.assertEquals(inputFile, null);

    }

    // The client checks for a valid file, no need for this test
    // @Test
    public void validFileTest() {
        // TODO: This should be testing builder logic now
//        mock everything but the input file in InputConfig, have it be a fake file
//        inputConfig isn't mocked because i'm testing the constructor for it
        File inputFile = new File("/csvTest.txt");
        InputType mockInputType = Mockito.mock(InputType.class);
//        InputConfig inputConfig = new InputConfig(inputFile, mockInputType);

        Assert.assertTrue(inputFile.exists());

    }

}
