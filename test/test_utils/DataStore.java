package test_utils;

public class DataStore {

    private int storedData;

    public void storeData(int data) {
        this.storedData = data;
        System.out.println("Data Store: Data stored successfully.");
    }

    public int getStoredData() {
        return storedData;
    }
}
