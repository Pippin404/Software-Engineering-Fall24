package assignmentsix;


import apis.us.UScomputerEngineConstructer;

import java.io.File;


public class Testuser {
	
	// DONE 6.C.3: change the type of this variable to the name you're using for your
	// User <-> ComputeEngine API; also update the parameter passed to the constructor DONE
    //Pippin Notes: There isn't a toString function or anything. I wonder how our code is going to integrate with this
	private final UScomputerEngineConstructer coordinator;

	public Testuser(UScomputerEngineConstructer coordinator) {
		this.coordinator = coordinator;
	}

	public void run(String outputPath) {
		char delimiter = ';';
		String inputPath = "test" + File.separatorChar + "testInputFile.test";

		// TODO 6.C.4: Call the appropriate method(s) on the coordinator to get it to
		// run the compute job specified by inputPath, outputPath, and delimiter
	}

}
