package ds.unittests;

import apis.ds.FileParseRequest;
import inputoutput.Delimiter;
import inputoutput.InputConfig;
import inputoutput.InputType;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;


import java.io.File;
import java.io.FileNotFoundException;

public class FileReading {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void invalidDelimiter() {
//        mock everything else to just test putting in a null InputConfig
        File mockInputFile = Mockito.mock(File.class);
        InputType mockInputType = Mockito.mock(InputType.class);
//        FileParseRequest fileParseRequest = new FileParseRequest(mockInputConfig, null);
        FileParseRequest fileParseRequest = FileParseRequest.builder()
                                                            .inputFile(mockInputFile)
                                                            .inputType(mockInputType)
                                                            .delimiter(null)
                                                            .build();

        exception.expect(IllegalArgumentException.class);
    }

    @Test
    public void invalidInputType() {
        Delimiter delimiter = Mockito.mock(Delimiter.class);
        File mockInputFile = Mockito.mock(File.class);
        FileParseRequest fileParseRequest = FileParseRequest.builder()
                                                            .inputType(null)
                                                            .delimiter(delimiter)
                                                            .inputFile(mockInputFile)
                                                            .build();

        exception.expect(IllegalArgumentException.class);
    }

    @Test
    public void invalidFileTest() {
        // TODO: This should be testing builder logic now
//        mock everything but the input file in InputConfig, have it be a fake file
//        inputConfig isn't mocked because i'm testing the constructor for it
        File inputFile = new File("wobungus/blungus");
        InputType mockInputType = Mockito.mock(InputType.class);
        InputConfig inputConfig = new InputConfig(inputFile, mockInputType);

        exception.expect(FileNotFoundException.class);

    }

    @Test
    public void validFileTest() {
        // TODO: This should be testing builder logic now
//        mock everything but the input file in InputConfig, have it be a fake file
//        inputConfig isn't mocked because i'm testing the constructor for it
        File inputFile = new File("C:\\Users\\eribr\\Desktop\\Software Engineering\\Software-Engineering-Fall24\\test\\ds\\iotests\\csvTest.txt");
        InputType mockInputType = Mockito.mock(InputType.class);
//        InputConfig inputConfig = new InputConfig(inputFile, mockInputType);

        Assert.assertTrue(inputFile.exists());

    }



}
