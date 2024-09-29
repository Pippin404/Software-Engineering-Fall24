package testutils;

import java.util.List;

import ce.InternalComputeEngineTest;

public class Coordinator {

    private InternalComputeEngineTest computeEngine;
    private Integer data;
    
    public Coordinator(InternalComputeEngineTest computeEngine) {
        this.computeEngine = computeEngine;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }

    public void sendDataToComputeEngine() {
        System.out.println("Coordinator: Sending data to Compute Engine.");
        computeEngine.setData(data);
    }
}
