package test_utils;

import java.util.List;

public class Coordinator {

    private InternalComputeEngine computeEngine;
    
    // Example data
    List<Integer> myList = Arrays.asList(1, 10, 25);


    public Coordinator(InternalComputeEngine computeEngine) {
        this.computeEngine = computeEngine;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }

    public void sendDataToComputeEngine() {
        System.out.println("Coordinator: Sending data to Compute Engine.");
        computeEngine.receiveData(data);
    }
}

}
