package placeholders;

import java.util.List;

import apis.ce.InternalComputeEngine;

public class CoordinatorPlaceholder {

    private Integer data;
    

    public void setData(Integer data) {
        this.data = data;
    }

    public void sendDataToComputeEngine() {
        System.out.println("Coordinator: Sending data to Compute Engine.");
        computeEngine.setData(data);
    }
}
