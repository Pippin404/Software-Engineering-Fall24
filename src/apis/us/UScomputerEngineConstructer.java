package apis.us;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import apis.ce.InternalComputeEngine;
import apis.ds.DataStore;
import apis.ds.ParseInputFileRequest;
import apis.ds.ParseInputFileResponse;
import inputoutput.InputConfig;
import inputoutput.InputType;
import inputoutput.Delimiter;


public class UScomputerEngineConstructer {

        //Make an "InternalComputeEngine" to pass the data to the CE
        private InternalComputeEngine computeEngine;
        private DataStore dataStore;
        private UserCommunicatorImpl commHandler=null;
        private Integer data;
        private File inputFile;  // Store the file as a file object


        
        public UScomputerEngineConstructer(InternalComputeEngine computeEngine, DataStore dataStore) {
        if (dataStore == null || computeEngine == null) {
           throw new IllegalArgumentException("Data cannot be null");
        }
        this.computeEngine=computeEngine;
        this.dataStore = dataStore;    
        }

        public void setInputFile(File file) {
            this.inputFile = file;
            System.out.println("Reading data from: " + this.inputFile.getName()); 
            // ^ conformation message for file setting (remove if you want)
        }

        // get method for file
        public File getInputFile() {
            return this.inputFile;
        }


        //  TODO: That is a crazy solution to a null pointer problem we should not do this lmao
        public void setData() {
            
            if(this.commHandler==null) {
                this.commHandler=new UserCommunicatorImpl();
            }



            // Create InputConfig and ParseInputFileRequest for DataStore
            InputConfig inputConfig = new InputConfig(inputFile, InputType.CSV);
            Delimiter delimiter = Delimiter.COMMA;
            ParseInputFileRequest request = new ParseInputFileRequest(inputConfig, delimiter);

            // Parse the file using DataStore
            ParseInputFileResponse response = dataStore.parseInputFile(request);
            List<Integer> numbers = response.getParsedIntegers();
            System.out.println("Numbers read from file in coordinator: " + numbers);
            
            
            // Default to [1, 2, 3] if the file is empty
            if (numbers.isEmpty()) {
                numbers = Arrays.asList(1, 2, 3);
            }

            // Set data to the first number in the list
            this.data = numbers.get(0);
        }

        public Integer runInternalCompute(int i) {
            return computeEngine.computeNthFibonacci(i);
        }

        public Integer getData() {
            return data;
        }
      
        public void setComputeEngine(InternalComputeEngine computeEngine) {
            this.computeEngine = computeEngine;
        }
        
        public void sendDataToComputeEngine() {
            System.out.println("US: Adding data to computeEngine.data");
            computeEngine.setData(data);
            this.setData();
        }
        
}
