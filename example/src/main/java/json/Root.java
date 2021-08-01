package json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Root {

	    @JsonProperty("Entities") 
	    private List<Entity> entities;
	    @JsonProperty("ResponseMetadata") 
	    private ResponseMetadata responseMetadata;
	    
		public List<Entity> getEntities() {
			return entities;
		}
		public ResponseMetadata getResponseMetadata() {
			return responseMetadata;
		}
	
	    
}
