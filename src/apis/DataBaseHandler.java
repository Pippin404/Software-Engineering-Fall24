public class DataBaseHandler implements DataPackage{

	// Placeholder Values
	private Integer data = null;
	private String message = null;

	@Override
	public void setData(int i) {
        	data = i;
    	}

	@Override
    	public int getData() {
		if (data != null) {
            	return data;
        	}
        return 0;
    	}

	@Override
    	public void setMessage(String s) {
        	message = s;
    	}

	@Override
    	public String getMessage() {
        	if (message == null) {
            	String n = "Default Message";
            	return n;
        	} else {
            	return message;
        	}
    	}

	// implement later
    	public int writingNumber() {
        return 0; // Placeholder return value
	}

	
	

		
}
