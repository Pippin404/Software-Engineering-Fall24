package placeholders;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class DatastorePlaceholder {

    private int storedData;
    private static final String FILE_NAME = "data.txt"; // name for file written to

    // Everytime storeData is used writeDataToFile activates and writes to data.txt
    public void storeData(int data) {
        this.storedData = data;
        writeDataToFile(data);
        System.out.println("Data Store: Data stored successfully. Value is: " + data);
    }

    public int getStoredData() {
        return storedData;
    }

    // Method to write data to the file
    private void writeDataToFile(int data) {
        File file = new File(FILE_NAME);
        FileWriter writer = null;
        try {
            // Makes the new file or adds to it if it already exists
            writer = new FileWriter(file, true);

            // Add data and a new line to the file
            writer.write(data + "\n");

        // Catch any error, throw exception
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("An error occurred while closing the file writer: " + e.getMessage());
            }
        }
    }
}
