package apis;

import java.util.ArrayList;

public class InMemoryImplimentationDataStore {
    
    
    //create input and output
    ArrayList<Integer> inputData = new ArrayList<Integer>();
    inputData.add(4);
    inputData.add(6);
    inputData.add(10);

    ArrayList<String> FileData = new ArrayList<String>();
    
    //loop thru array, inputting items
    for(int i=0;i<=inputData.size();i++) {
        string s=inputInfo(inputdata.get(i));
        System.out.println(s);
        FileData.add(inputInfo.get(i));
    }    
    
    System.out.println(FileData);
}


public class inputInfo(int i) implements DataBaseHandler{
    String S = storeData(i);
   //hmmm why is this returning a string? is it the return adress of the file we are placing?
}