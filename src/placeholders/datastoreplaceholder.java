// Placeholder for real data store. Delete this after real one is implemented

package placeholders;

public class datastoreplaceholder {

    private int storedData;

    public void storeData(int data) {
        this.storedData = data;
        System.out.println("Data Store: Data stored successfully. Value is: "+ data);
    }

    public int getStoredData() {
        return storedData;
    }
}
