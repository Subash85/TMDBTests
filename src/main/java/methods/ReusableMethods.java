package methods;

import io.restassured.response.Response;
import org.testng.annotations.DataProvider;

import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReusableMethods {

    public static Response searchWithMovieName(String baseUrl,String searchQuery,String key,String path){

        Response response = given()
                .baseUri(baseUrl)
                .queryParam("api_key",key)
                .queryParam("query",searchQuery)
                .when().basePath(path)
                .get();

        return response;
    }

    public static String getProperties(String propertyName){

        String infoFromFile = " ";

        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("src/config.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty(propertyName));
            infoFromFile = prop.getProperty(propertyName);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return infoFromFile;
    }

}
