package json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseMetadata {

	@JsonProperty("RequestId") 
	private String requestId;
	@JsonProperty("HTTPStatusCode") 
	private int hTTPStatusCode;
	@JsonProperty("HTTPHeaders") 
	private HTTPHeaders hTTPHeaders;
	@JsonProperty("RetryAttempts") 
	private int retryAttempts;
	
	public String getRequestId() {
		return requestId;
	}
	public int gethTTPStatusCode() {
		return hTTPStatusCode;
	}
	public HTTPHeaders gethTTPHeaders() {
		return hTTPHeaders;
	}
	public int getRetryAttempts() {
		return retryAttempts;
	}
	
	

}
