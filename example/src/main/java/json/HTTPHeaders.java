package json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HTTPHeaders {
	@JsonProperty("content-type") 
	private String contentType;
	private String date;
	@JsonProperty("x-amzn-requestid") 
	private String xAmznRequestid;
	@JsonProperty("content-length") 
	private String contentLength;
	private String connection;
	
	public String getContentType() {
		return contentType;
	}
	public String getDate() {
		return date;
	}
	public String getxAmznRequestid() {
		return xAmznRequestid;
	}
	public String getContentLength() {
		return contentLength;
	}
	public String getConnection() {
		return connection;
	}
	
	

}
