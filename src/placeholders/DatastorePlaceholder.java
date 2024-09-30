package placeholders;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class DatastorePlaceholder {

    private int storedData;
    private static final String FILE_NAME = "data.txt";

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
            // Use FileWriter with 'true' for append mode
            writer = new FileWriter(file, true);

            // Check if the file exists, otherwise create it (FileWriter will handle it)
            if (!file.exists()) {
                file.createNewFile();
            }

            // Append the data and add a new line
            writer.write(data + "\n");

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
