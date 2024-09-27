package testutils;

import java.util.List;

public class Coordinator {

    private InternalComputeEngine computeEngine;
    private List<Integer> data;
    
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
