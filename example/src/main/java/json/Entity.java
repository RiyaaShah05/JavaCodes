package json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Entity {

	@JsonProperty("Id") 
	private int id;
	@JsonProperty("BeginOffset") 
	private int beginOffset;
	@JsonProperty("EndOffset") 
	private int endOffset;
	@JsonProperty("Score") 
	private double score;
	@JsonProperty("Text") 
	private String text;
	@JsonProperty("Category") 
	private String category;
	@JsonProperty("Type") 
	private String type;
	@JsonProperty("Traits") 
	private List<Object> traits;
	
	public int getId() {
		return id;
	}
	public int getBeginOffset() {
		return beginOffset;
	}
	public int getEndOffset() {
		return endOffset;
	}
	public double getScore() {
		return score;
	}
	public String getText() {
		return text;
	}
	public String getCategory() {
		return category;
	}
	public String getType() {
		return type;
	}
	public List<Object> getTraits() {
		return traits;
	}
	
	

}
