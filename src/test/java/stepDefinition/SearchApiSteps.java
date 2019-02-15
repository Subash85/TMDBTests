package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.fail;

import methods.ReusableMethods;
import org.testng.annotations.DataProvider;


public class SearchApiSteps {

    public static String requestUrl;
    public static String apikey;
    public static Response response;
    public static String  moviePathParam = "movie";
    public static String  tvPathParam = "tv";
    public static boolean  include_adult;
    public static int year;
    public static String region;


    public SearchApiSteps(){
        requestUrl=ReusableMethods.getProperties("searchApi");
    }


    @Given("^the user have an  valid Api Key$")
    public void the_user_have_an_valid_Api_Key() throws Throwable {
        apikey=ReusableMethods.getProperties("api_key");
    }

    @When("^the user hits url with movie \"([^\"]*)\" using the key$")
    public void the_user_hits_url_with_movie_using_the_key(String movieName) throws Throwable {
        response = ReusableMethods.searchWithMovieName(requestUrl,movieName,apikey,moviePathParam);
    }

    @And("^we get a success (\\d+)$")
    public void we_get_a_success(int statusCode ) throws Throwable {
        if (response.statusCode() == 200) {
            System.out.println("Successfully  searched "+response.statusLine());
        } else {
            System.out.println("Ouch! Error Response"+response.asString());
            fail("Error occurred while searching");
        }
    }

    @Then("^user should see the search results$")
    public void user_should_see_the_search_results() throws Throwable {
        System.out.println("response1"+response.asString());
        }


    @When("^the user hits url with tv show \"([^\"]*)\" using the key$")
    public void the_user_hits_url_with_tv_show_using_the_key( String tvTitle) throws Throwable {
        response = ReusableMethods.searchWithMovieName(requestUrl,tvTitle,apikey,tvPathParam);
    }


    @Given("^the user have an invalid  Api Key$")
    public void the_user_have_an_invalid_Api_Key()  throws Throwable {
        apikey=ReusableMethods.getProperties("invalidApiKey");

    }

    @Then("^user should get a failure (\\d+)$")
    public void user_should_get_a_failure(int errorCode) throws Throwable {
        if (response.statusCode() == errorCode) {
            System.out.println("Not a valid API error response \n"+response.statusLine());
        } else {
            System.out.println("Not an expected result"+response.asString());
            fail("Error occurred while searching");
        }
    }






}
