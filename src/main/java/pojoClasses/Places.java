package pojoClasses;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class Places {
	
	

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({
	"place name",
	"longitude",
	"state",
	"state abbreviation",
	"latitude"
	})
	


	@JsonProperty("place name")
	private String placeName;
	@JsonProperty("longitude")
	private String longitude;
	@JsonProperty("state")
	private String state;
	@JsonProperty("state abbreviation")
	private String stateAbbreviation;
	@JsonProperty("latitude")
	private String latitude;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("place name")
	public String getPlaceName() {
	return placeName;
	}

	@JsonProperty("place name")
	public void setPlaceName(String placeName) {
	this.placeName = placeName;
	}

	@JsonProperty("longitude")
	public String getLongitude() {
	return longitude;
	}

	@JsonProperty("longitude")
	public void setLongitude(String longitude) {
	this.longitude = longitude;
	}

	@JsonProperty("state")
	public String getState() {
	return state;
	}

	@JsonProperty("state")
	public void setState(String state) {
	this.state = state;
	}

	@JsonProperty("state abbreviation")
	public String getStateAbbreviation() {
	return stateAbbreviation;
	}

	@JsonProperty("state abbreviation")
	public void setStateAbbreviation(String stateAbbreviation) {
	this.stateAbbreviation = stateAbbreviation;
	}

	@JsonProperty("latitude")
	public String getLatitude() {
	return latitude;
	}

	@JsonProperty("latitude")
	public void setLatitude(String latitude) {
	this.latitude = latitude;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}
}
