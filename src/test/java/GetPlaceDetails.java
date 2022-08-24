
import static org.junit.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given; //import this
import io.restassured.response.Response;

//import pojoClasses.PlaceDetails;
import pojoClasses.PlaceTotalDetails;
import utility.AllureLogger;
import utility.BaseTest;
import utility.ExcelLib;

public class GetPlaceDetails extends BaseTest {
	
	@DataProvider (name="DataFromExcel")
	public Object[][] data() throws Exception {
		ExcelLib xl = new ExcelLib("Place", this.getClass().getSimpleName());
		return xl.getTestdata();
	}
    
	@Test(dataProvider="DataFromExcel", description="To retrieve the details of the Place details ") 
	public void getPlaceDetails(String zipcode, String country,String countryabbrevation,
							  String placename, 
							  String longitude,
							  String state, 
							  String stateabbrevation, 
							  String latitude,
							  String dontusethis
						
							  ){
		
		AllureLogger.logToAllure("Starting the test to get Place details");
		/*******************************************************
		 * Send a GET request for zip code
		 * and check that the response has HTTP status code 200
		 ******************************************************/
		
		//Sending the GET request for a specific zip code and getting the response
		AllureLogger.logToAllure("Getting the response for the zip codes  from test data excel");
		Response response = given().
				spec(requestSpec).
				pathParam("zipcode", zipcode).
			when().
				get("/us/{zipcode}");
		
		//Verify the response code
		AllureLogger.logToAllure("Asserting the response if the status code returned is 200");
		response.then().spec(responseSpec);		

		//To log the response to report
		logResponseAsString(response);
		
		
		//Using the POJO class
		AllureLogger.logToAllure("Asserting of response body with the data from test data excel");
		
		PlaceTotalDetails checkplacedetails = response.as(PlaceTotalDetails.class);
		
		Assert.assertEquals(checkplacedetails.getPostCode(),zipcode);
			
		
		
		Assert.assertEquals(checkplacedetails.getCountry(), country);
		Assert.assertEquals(checkplacedetails.getCountryAbbreviation(), countryabbrevation);
		Assert.assertEquals(checkplacedetails.getPlaces().get(0).getPlaceName(),placename);
		Assert.assertEquals(checkplacedetails.getPlaces().get(0).getLongitude(),longitude);
		Assert.assertEquals(checkplacedetails.getPlaces().get(0).getState(), state);
		Assert.assertEquals(checkplacedetails.getPlaces().get(0).getStateAbbreviation(), stateabbrevation);
		Assert.assertEquals(checkplacedetails.getPlaces().get(0).getLatitude(),latitude);
		
	}
}
