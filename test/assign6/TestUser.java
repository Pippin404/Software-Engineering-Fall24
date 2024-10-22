package assign6;



import java.io.File;

import apis.us.UScomputerEngineConstructer;


public class TestUser {
	
	// DONE TODO 3: change the type of this variable to the name you're using for your
	// User <-> ComputeEngine API; also update the parameter passed to the constructor DONE
    //Pippin Notes: There isn't a toString function or anything. I wonder how our code is going to integrate with this
	private final UScomputerEngineConstructer coordinator;

	public TestUser(UScomputerEngineConstructer coordinator) {
		this.coordinator = coordinator;
	}

	public void run(String outputPath) {
		char delimiter = ';';
		String inputPath = "test" + File.separatorChar + "testInputFile.test";
		
		// TODO 4: Call the appropriate method(s) on the coordinator to get it to 
		// run the compute job specified by inputPath, outputPath, and delimiter
	}

}
