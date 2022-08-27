package mvcbunch;

import java.sql.Timestamp; 
public class Message {
	
	private String name;
	private String post;
	private Timestamp timestamp;
	
	public Message (String name, String post,Timestamp postTime) {
		this.name = name;
		this.post = post;
		this.timestamp = postTime;
	}

	public String getName() {
		return name;
	}

	public String getPost() {
		return post;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

}
