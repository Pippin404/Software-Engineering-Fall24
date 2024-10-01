package apis.us;

import apis.ce.InternalComputeEngine;

public class UScomputerEngineConstructer {

        //Make an "InternalComputeEngine" to pass the data to the CE
        private InternalComputeEngine computeEngine;
        private Integer data;
        private UserCommunicatorImpl commHandler;
        
        public UScomputerEngineConstructer(InternalComputeEngine computeEngine) {
            // TODO Auto-generated constructor stub
        }

//        TODO: That is a crazy solution to a null pointer problem we should not do this lmao
        public void setData() {
            //Ask the rest of my code for the data
            //set the data in computerEngine to the data we get from my other code
            //right now it just returns 5
            if(commHandler==null) {
                @SuppressWarnings("unused")
                UserCommunicatorImpl commHandler=new UserCommunicatorImpl();

            }
            this.data = commHandler.getUserInput();
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
        }
        
}
