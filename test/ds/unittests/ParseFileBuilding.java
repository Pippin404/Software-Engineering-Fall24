package ds.unittests;

import apis.ds.FileParseRequest;
import inputoutput.Delimiter;
import inputoutput.InputType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ParseFileBuilding {

    private static final String VALID_FILE_PATH = "test/ds/iotests/csvTest.txt";
    private static final String INVALID_FILE_PATH = "aaa";
    private static final File VALID_FILE = new File(VALID_FILE_PATH);
    private static final File INVALID_FILE = new File(INVALID_FILE_PATH);

    private Delimiter validDelimiter;
    private InputType validInputType;

    @BeforeEach
    void setUp() {
        validDelimiter = Delimiter.COMMA;
        validInputType = InputType.CSV;
    }

    @Test
    void successfulBuild() {
        FileParseRequest request = FileParseRequest.builder()
                .delimiter(validDelimiter)
                .inputFile(VALID_FILE)
                .inputType(validInputType)
                .build();

        assertNotNull(request);
        assertEquals(validDelimiter, request.getDelimiter());
        assertEquals(VALID_FILE, request.getInputFile());
        assertEquals(validInputType, request.getInputType());
    }

    @Test
    void nullDelimiter() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            FileParseRequest.builder()
                    .delimiter(null)
                    .inputFile(VALID_FILE)
                    .inputType(validInputType)
                    .build();
        });

        assertEquals("Delimiter type cannot be null.", thrown.getMessage());
    }

    @Test
    void nullInputFile() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            FileParseRequest.builder()
                    .delimiter(validDelimiter)
                    .inputFile(null)
                    .inputType(validInputType)
                    .build();
        });

        assertEquals("Input file cannot be null.", thrown.getMessage());
    }

    @Test
    void nonExistingFile() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            FileParseRequest.builder()
                    .delimiter(validDelimiter)
                    .inputFile(INVALID_FILE)
                    .inputType(validInputType)
                    .build();
        });

        assertTrue(thrown.getMessage().contains("Invalid input file"));
    }

    @Test
    void nullInputType() {
        // Test when input type is null
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            FileParseRequest.builder()
                    .delimiter(validDelimiter)
                    .inputFile(VALID_FILE)
                    .inputType(null)
                    .build();
        });

        assertEquals("Input type cannot be null.", thrown.getMessage());
    }

    @Test
    void missingInputType() {
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            FileParseRequest.builder()
                    .delimiter(validDelimiter)
                    .inputFile(VALID_FILE)
                    .build();
        });

        assertEquals("Input type is required.", thrown.getMessage());
    }
}

