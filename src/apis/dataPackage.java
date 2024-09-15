interface dataPackage{
		private void data();
		private void message();
	
	
		public void setData(int i) {
			data=i;
		}
		
		public int getData() {
			if(data!=null) {
				return data;
			}
			return 0;
		}
		
		public void setMessage(string s) {
			message=s;
		}
		
		public string getMessage() {
			if(message==null) {
				var n="Default Message";
				return n;
			}else{
				return message;
			}
		}
	}