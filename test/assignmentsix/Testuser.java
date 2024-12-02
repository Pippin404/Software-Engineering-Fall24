package assignmentsix;


import apis.ce.InternalComputeEngine;
import apis.ds.DataStore;
import apis.us.UScomputerEngineConstructer;

import java.io.File;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;



public class Testuser {
	
	// DONE 6.C.3: change the type of this variable to the name you're using for your
	// User <-> ComputeEngine API; also update the parameter passed to the constructor DONE
    //Pippin Notes: There isn't a toString function or anything. I wonder how our code is going to integrate with this
	private final UScomputerEngineConstructer coordinator;

	public Testuser(UScomputerEngineConstructer coordinator) {
		this.coordinator = coordinator;
	}


	public void run(String outputPath) {
		char delimiter = '.';
		String inputPath = "C:\\Users\\eribr\\Desktop\\Software Engineering\\Software-Engineering-Fall24\\test\\ testInputFile.test";

		// TODO 6.C.4: Call the appropriate method(s) on the coordinator to get it to
		// run the compute job specified by inputPath, outputPath, and delimiter
		// Initializing template datastore
		apis.ds.DataStore dataStore = new DataStore();

		// Initializing internal compute engine with template datastore

		InternalComputeEngine computeEngine = new InternalComputeEngine();

		// Initialize Coordinator with InternalComputeEngine
		UScomputerEngineConstructer coordinator = new UScomputerEngineConstructer(computeEngine, dataStore);

//		Testuser testuser = new Testuser(coordinator); <- not sure what this line is doing 
//		TODO: Call the Coordinator's methods for parsing the file and computing the data

		// added methods to get List<Integer> from file and send it to internal compute
		File inputFile = new File(inputPath);
		coordinator.setInputFile(inputFile);
		coordinator.setData();
		List<Integer> computedResults = coordinator.runInternalComputeWithThreading(coordinator.getData());

		writeResultsToFile(computedResults, outputPath);

		


		
//		List<Integer> parsedIntegers = coordinator.parseInputFile();
//		Foo results = Call the compute engine to do the calculation
//		coordinator.writeToFile(outputFile, results)
	}

	private void writeResultsToFile(List<Integer> results, String outputPath) {
        	try (FileWriter writer = new FileWriter(outputPath)) {
            	for (int result : results) {
                    writer.write(result + "\n");  // Write each result on a new line
            	}
            	System.out.println("Results successfully written to " + outputPath);
        	} catch (IOException e) {
        	System.out.println("Error writing results to file: " + e.getMessage());
            		e.printStackTrace();
        	}
    	}


}
