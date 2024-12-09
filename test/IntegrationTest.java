import org.junit.jupiter.api.Test;
import apis.ce.InternalComputeEngine;
import apis.ce.InternalComputeEngine2;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class IntegrationTest {

	@Test
	public void integrationTesting() {
		  
	int x = 1000; // number of values
	int y = 0;    // minimum value
	int z = 50;  // maximum value
	Random random = new Random();

	List<Integer> testValues = new ArrayList<>(x);
	for (int i = 0; i < x; i++) {
	    testValues.add(random.nextInt(z - y + 1) + y);
	}
	
	
	
	InternalComputeEngine computeEngine1 = new InternalComputeEngine();
	InternalComputeEngine2 computeEngine2 = new InternalComputeEngine2();
	
	// Measure time for computeNthFibonacci
    long startTime1 = System.nanoTime();
    for (int value : testValues) {
        computeEngine1.computeNthFibonacci(value);
    }
    long endTime1 = System.nanoTime();
    long duration1 = endTime1 - startTime1;
    System.out.println("Total time for computeNthFibonacci: " + duration1 + " ns");
    
 // Measure time for betterComputeNthFibonacci
    long startTime2 = System.nanoTime();
    for (int value : testValues) {
    	computeEngine2.computeNthFibonacci(value);
    }
    long endTime2 = System.nanoTime();
    long duration2 = endTime2 - startTime2;
    System.out.println("Total time for betterComputeNthFibonacci: " + duration2 + " ns");
    
    
    
    if (duration2 < duration1) {
        System.out.println("betterComputeNthFibonacci is faster by " + (duration1 - duration2) + " ns.");
        System.out.println("betterComputeNthFibonacci is faster by " + 100*((double)duration1/(double)duration2) + "%");
    } else if (duration1 < duration2) {
        System.out.println("computeNthFibonacci is faster by " + (duration2 - duration1) + " ns.");
        System.out.println("computeNthFibonacci is faster by " + 100*((double)duration2/(double)duration1));
    } else {
        System.out.println("Both methods have the same execution time.");
    }
    
	}






}
