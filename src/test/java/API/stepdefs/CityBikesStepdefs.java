package API.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.CityBikes;
import model.Location;
import model.Networks;
import org.junit.Assert;

public class CityBikesStepdefs {
    private static Response response;
    CityBikes citybikesPOJO;
    Networks network;

    @Given("I call city bikes API networks endpoint {string}")
    public void iCallCityBikesAPINetworksEndpoint(String URL) {
        RestAssured.baseURI = URL;
        RequestSpecification httpRequest = RestAssured.given();
        response = httpRequest.request(Method.GET,"/networks");
        citybikesPOJO= response.getBody().as(CityBikes.class);
    }

    @Then("I have a valid response from the API")
    public void iHaveAValidResponseFromTheAPI() {
        Assert.assertEquals("Status Code is : 200",response.getStatusCode(),200);
    }

    @Then("Verify that city {string} is in Germany with country code {string}")
    public void verifyThatCityIsInGermanyWithCountryCode(String city, String country) {
        for (Networks network : citybikesPOJO.getNetworks()) {
            if (city.equalsIgnoreCase(network.getLocation().getCity())
                    && country.equalsIgnoreCase(network.getLocation().getCountry())) {
                this.network = network;
            }
        }
    }

    @And("I receive it's corresponding latitude and longitude values")
    public void iReceiveItSCorrespondingLatitudeAndLongitudeValues() {
        Location location = network.getLocation();
        Assert.assertTrue(location.getLatitude() != null);
        Assert.assertTrue(location.getLongitude() != null);
        System.out.println("Location of the city bikes in the city of "+location.getCity()+", "+location.getCountry()+" is :");
        System.out.println("Latitude: " + location.getLatitude());
        System.out.println("Longitude: " + location.getLongitude());
    }

    @Then("Verify that city {string} is in a country with country code {string}")
    public void verifyThatCityIsInACountryWithCountryCode(String city, String country) {
        for (Networks network : citybikesPOJO.getNetworks()) {
            if (city.equalsIgnoreCase(network.getLocation().getCity())
                    && country.equalsIgnoreCase(network.getLocation().getCountry())) {
                this.network = network;
            }
        }
    }

    @Then("Verify that the {string} city bikes network is having a valid {string}")
    public void verifyThatTheCityBikesNetworkIsHavingAValid(String networkName, String openLicense) {
        for(Networks network: citybikesPOJO.getNetworks()){
            if(network.getName() != null && network.getLicense() != null && networkName.equalsIgnoreCase(network.getName())
                    && openLicense.equalsIgnoreCase(network.getLicense().getName())){
                this.network = network;
                System.out.println("Network "+network.getName()+" is having a valid " +network.getLicense().getName());
            }
        }
    }
}
