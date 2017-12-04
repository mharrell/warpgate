package Common;

//import io.restassured.RestAssured;
//import org.apache.commons.httpclient.HttpMethod;
//import org.apache.commons.httpclient.methods.GetMethod;
//import org.testng.Assert;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//import io.restassured.RestAssured.*;
//import io.restassured.matcher.RestAssuredMatchers.*;
//
//import static io.restassured.RestAssured.get;
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;
//import static org.testng.Assert.*;

import io.restassured.RestAssured;

import java.io.File;
import java.lang.System;

import static io.restassured.RestAssured.get;
import static org.hamcrest.core.IsEqual.equalTo;


public class testSetup {


    public static void getTestFiles() {

        System.out.println("---Beginning Test Setup---");
        System.out.println("---Gathering Test Scenarios---");

        //TODO: Figure out how to just use the relative path.
        File folder = new File("/Users/mharrell/IdeaProjects/warpgate/src/test/java/TestCases");

        System.out.println("Path exists: " + folder.exists());
        System.out.println("Path is directory: " + folder.isDirectory());
        System.out.println("Path exists: " + folder.canRead());

        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
                File[] directories = listOfFiles[i].listFiles();

                for (int j = 0; j < directories.length; j++) {
                    if (directories[j].isFile()) {

                        System.out.println("File " + directories[j].getName());
                        createTest("https://api.themoviedb.org/", "3/movie/", "ecbb6d04d338fac6ecb9caad0fbd475b",
                                "550", "budget", "630000");

                    } else if (directories[j].isDirectory()) {
                        System.out.println("Directory " + directories[j].getName());


                    }
                }
            }
        }
    }

    public static String createTest(String uri, String path, String validation, String query, String response, String expected){
        String test;

        RestAssured.reset();
        RestAssured.basePath = path;
        RestAssured.baseURI = uri;

        test = buildRequest.buildGetter(validation, query, response, expected);

//        System.out.println(test);

//        if type "GET" then
            get(test);
//            get("/550?api_key=ecbb6d04d338fac6ecb9caad0fbd475b").then().body("budget", equalTo(63000000));

//        else if type "PUT" then
//          put(test);

//        else if type "POST" then
//          post(test);

//        else
//          delete(test);

        return test;
    }


}