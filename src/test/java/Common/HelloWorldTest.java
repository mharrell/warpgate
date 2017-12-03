package Common;

import io.restassured.RestAssured;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.*;

public class HelloWorldTest {



    @BeforeTest
    public static void setup() {


        RestAssured.basePath = "/3/movie";

        RestAssured.baseURI = "https://api.themoviedb.org";


    }


    @Test
    public void testHelloWorld() throws Exception {
        String concatenated = "I bet your mom looks great today!";

//        Assert.assertEquals("this should fail", concatenated);
        Assert.assertEquals("I bet your mom looks great today!", concatenated);

    }
    @Test
    public void testAPIResponse() throws Exception {

        get("/550?api_key=ecbb6d04d338fac6ecb9caad0fbd475b").then().body("budget", equalTo(630000));

    }

}


//TODO: rename everything so it makes some freaking sense
//TODO: Check what's available in the API
//TODO: Figure out how to pull in a json from the movieDB api
//TODO: Start writing some test cases
//TODO: implement REST Assured?
//TODO: implement a few of those cases!

//working request for moviedb:
//        https://api.themoviedb.org/3/movie/550?api_key=ecbb6d04d338fac6ecb9caad0fbd475b









