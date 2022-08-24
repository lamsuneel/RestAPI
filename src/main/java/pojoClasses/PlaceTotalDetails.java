package pojoClasses;


import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"post code",
"country",
"country abbreviation",
"places"
})

public class PlaceTotalDetails {

@JsonProperty("post code")
private String postCode;
@JsonProperty("country")
private String country;
@JsonProperty("country abbreviation")
private String countryAbbreviation;
@JsonProperty("places")
private List<Places> places = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("post code")
public String getPostCode() {
return postCode;
}

@JsonProperty("post code")
public void setPostCode(String postCode) {
this.postCode = postCode;
}

@JsonProperty("country")
public String getCountry() {
return country;
}

@JsonProperty("country")
public void setCountry(String country) {
this.country = country;
}

@JsonProperty("country abbreviation")
public String getCountryAbbreviation() {
return countryAbbreviation;
}

@JsonProperty("country abbreviation")
public void setCountryAbbreviation(String countryAbbreviation) {
this.countryAbbreviation = countryAbbreviation;
}

@JsonProperty("places")
public List<Places> getPlaces() {
return places;
}

@JsonProperty("places")
public void setPlaces(List<Places> places) {
this.places = places;
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


	

