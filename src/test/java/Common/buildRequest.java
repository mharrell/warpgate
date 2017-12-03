package Common;

import io.restassured.RestAssured;

public class buildRequest {


    public static String buildGetter(String validation, String query, String response, String expected){
        String request;

        request = "\"/" + query + "?api_key=" + validation + "\").then().body(\"" + response + "\", equalTo(" + expected +")";

        return request;

    }

//    TODO: similar method for "put" requests
//    public String buildPutter();

//    TODO: similar method for "post" requests
//    public String buildPoster();

//    TODO: similar method for "delete" requests
//    public String buildDeleter();

}
