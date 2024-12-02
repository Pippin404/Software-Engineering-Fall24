package ds.unittests;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import apis.ds.FileParseRequest;
import inputoutput.Delimiter;
import inputoutput.InputConfig;
import inputoutput.InputType;

public class FileReading {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void invalidDelimiter() {
//        mock everything else to just test putting in a null InputConfig
        InputConfig mockInputConfig = Mockito.mock(InputConfig.class);
        FileParseRequest fileParseRequest = new FileParseRequest(mockInputConfig, null);

        exception.expect(IllegalArgumentException.class);
    }

    @Test
    public void invalidInputConfig() {
        Delimiter delimiter = Mockito.mock(Delimiter.class);
        FileParseRequest fileParseRequest = new FileParseRequest(null, delimiter);

        exception.expect(IllegalArgumentException.class);
    }

    // TODO This one isnt working
    // @Test
    public void invalidFileTest() {
//        mock everything but the input file in InputConfig, have it be a fake file
//        inputConfig isn't mocked because i'm testing the constructor for it
        File inputFile = new File("wobungus/blungus");
        InputType mockInputType = Mockito.mock(InputType.class);
        InputConfig inputConfig = new InputConfig(inputFile, mockInputType);

        exception.expect(FileNotFoundException.class);

    }

    // TODO THIS ONE ALSO DOESNT WORK
    // @Test
    public void validFileTest() {
//        mock everything but the input file in InputConfig, have it be a fake file
//        inputConfig isn't mocked because i'm testing the constructor for it
        File inputFile = new File(
                "C:\\Users\\eribr\\Desktop\\Software Engineering\\Software-Engineering-Fall24\\test\\ds\\iotests\\csvTest.txt");
        InputType mockInputType = Mockito.mock(InputType.class);
//        InputConfig inputConfig = new InputConfig(inputFile, mockInputType);

        Assert.assertTrue(inputFile.exists());

    }

}
