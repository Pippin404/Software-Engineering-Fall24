package griffinapi;

public class SmokeTestGriffin {
    public static void main(String[] args) {
        InternalComputeEngine engine = new InternalComputeEngine();

        // testing set and get data
        engine.setData(5);
        if (engine.getData() == 5) {
            System.out.println("setData and getData passed.");
        } else {
            System.out.println("setData and getData failed.");
        }

        // testing compute() method
        if (engine.compute(10) == 1) {
            System.out.println("compute method passed (placeholder logic).");
        } else {
            System.out.println("compute method failed.");
        }

        // Smoke test for readInData
        if (engine.readInData("test") == 0) {
            System.out.println("readInData method passed.");
        } else {
            System.out.println("readInData method failed.");
        }

        
}
