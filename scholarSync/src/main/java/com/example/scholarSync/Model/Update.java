package com.example.scholarSync.Model;

public class Update {
	 private String title;
	    private String message;
		public Update(String title, String message) {
			super();
			this.title = title;
			this.message = message;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
	    
}
