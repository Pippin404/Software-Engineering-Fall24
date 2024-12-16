package ds.unittests;

import apis.ds.InternalWriteIntegerRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import inputoutput.OutputType;

import static org.junit.jupiter.api.Assertions.*;

class WriteRequestBuilding {

    private static final String VALID_OUTPUT_PATH = "test/ds/iotests/test.txt";
    private static final String INVALID_OUTPUT_PATH = "aaaaa";
    private static final OutputType VALID_OUTPUT_TYPE = OutputType.TEXT;

    private String validOutputPath;
    private OutputType validOutputType;

    @BeforeEach
    void setUp() {
        validOutputPath = VALID_OUTPUT_PATH;
        validOutputType = VALID_OUTPUT_TYPE;
    }

    @Test
    void successfulBuild() {
        // Test when all inputs are valid
        InternalWriteIntegerRequest request = InternalWriteIntegerRequest.builder()
                .outputPath(validOutputPath)
                .outputType(validOutputType)
                .computedInteger(42)
                .build();

        assertNotNull(request);
        assertEquals(validOutputPath, request.getOutputPath());
        assertEquals(validOutputType, request.getOutputType());
        assertEquals(42, request.getComputedInteger());
    }

    @Test
    void nullOutputPath() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            InternalWriteIntegerRequest.builder()
                    .outputPath(null)
                    .outputType(validOutputType)
                    .computedInteger(42)
                    .build();
        });

        assertEquals("Output path cannot be null or empty.", thrown.getMessage());
    }

    @Test
    void emptyOutputPath() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            InternalWriteIntegerRequest.builder()
                    .outputPath("")
                    .outputType(validOutputType)
                    .computedInteger(42)
                    .build();
        });

        assertEquals("Output path cannot be null or empty.", thrown.getMessage());
    }

    @Test
    void nullOutputType() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            InternalWriteIntegerRequest.builder()
                    .outputPath(validOutputPath)
                    .outputType(null)
                    .computedInteger(42)
                    .build();
        });

        assertEquals("Output type cannot be null.", thrown.getMessage());
    }

    @Test
    void testBuilder_withMissingOutputType_shouldThrowIllegalArgumentException() {
        // Test when outputType is missing (but outputPath is provided)
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            InternalWriteIntegerRequest.builder()
                    .outputPath(validOutputPath)
                    .computedInteger(42)
                    .build();
        });

        assertEquals("Output type cannot be null.", thrown.getMessage());
    }

    @Test
    void validComputedInteger() {
        int expectedInteger = 123;
        InternalWriteIntegerRequest request = InternalWriteIntegerRequest.builder()
                .outputPath(validOutputPath)
                .outputType(validOutputType)
                .computedInteger(expectedInteger)
                .build();

        assertEquals(expectedInteger, request.getComputedInteger());
    }
}
