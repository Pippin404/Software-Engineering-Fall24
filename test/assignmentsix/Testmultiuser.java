package assignmentsix;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import apis.ce.InternalComputeEngine;
import apis.ds.DataStore;
import apis.us.UScomputerEngineConstructer;

public class Testmultiuser {

    // DONE 6.B.1: change the type of this variable to the name you're using for
    // your
    // User <-> ComputeEngine API DONE
    private UScomputerEngineConstructer coordinator;

    @BeforeEach
    public void initializeComputeEngine() {
        // TODO 6.B.2: create an instance of your coordinator component; this is the
        // component
        // that the user will make requests to
        // Store it in the 'coordinator' instance variable
        // TODO!!!!
        // Initializing template datastore
        apis.ds.DataStore dataStore = new DataStore();

        // Initializing internal compute engine with template datastore

        InternalComputeEngine computeEngine = new InternalComputeEngine();

        // Initialize Coordinator with InternalComputeEngine
        coordinator = new UScomputerEngineConstructer(computeEngine, dataStore);
        // this shouldnt connect to grpc

    }

    // THIS TEST ALSO DOES NOT WORK
    // TODO: MAKE THIS NOT USE GRPC
    @Test
    public void compareMultiAndSingleThreaded() throws Exception {
        int numThreads = 4;
        List<Testuser> testUsers = new ArrayList<>();
        for (int i = 0; i < numThreads; i++) {
            testUsers.add(new Testuser(coordinator));
        }

        // Run single threaded
        String singleThreadFilePrefix = "testMultiUser.compareMultiAndSingleThreaded.test.singleThreadOut.tmp";
        for (int i = 0; i < numThreads; i++) {
            File singleThreadedOut = new File(singleThreadFilePrefix + i);
            singleThreadedOut.deleteOnExit();
            testUsers.get(i).run(singleThreadedOut.getCanonicalPath());
        }

        // Run multi threaded
        ExecutorService threadPool = Executors.newCachedThreadPool();
        List<Future<?>> results = new ArrayList<>();
        String multiThreadFilePrefix = "testMultiUser.compareMultiAndSingleThreaded.test.multiThreadOut.tmp";
        for (int i = 0; i < numThreads; i++) {
            File multiThreadedOut = new File(multiThreadFilePrefix + i);
            multiThreadedOut.deleteOnExit();
            String multiThreadOutputPath = multiThreadedOut.getCanonicalPath();
            Testuser testUser = testUsers.get(i);
            results.add(threadPool.submit(() -> testUser.run(multiThreadOutputPath)));
        }

        results.forEach(future -> {
            try {
                future.get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        // Check that the output is the same for multi-threaded and single-threaded
        List<String> singleThreaded = loadAllOutput(singleThreadFilePrefix, numThreads);
        List<String> multiThreaded = loadAllOutput(multiThreadFilePrefix, numThreads);
        Assert.assertEquals(singleThreaded, multiThreaded);
    }

    private List<String> loadAllOutput(String prefix, int numThreads) throws IOException {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < numThreads; i++) {
            File multiThreadedOut = new File(prefix + i);
            result.addAll(Files.readAllLines(multiThreadedOut.toPath()));
        }
        return result;
    }
}
