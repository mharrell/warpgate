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


import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;

import java.io.File;
import java.io.IOException;
import java.lang.System;
import java.util.List;

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
        ObjectMapper objectMapper = new ObjectMapper();


        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
                File[] directories = listOfFiles[i].listFiles();

                for (int j = 0; j < directories.length; j++) {
                    if (directories[j].isFile()) {

                        System.out.println("File " + directories[j].getName());
                        System.out.println("File " + directories[j].getPath());

                        try {
                            testCase testCase = objectMapper.readValue(new File(directories[j].getPath()), testCase.class);

                            createTest(testCase.getUri(), testCase.getPath(), testCase.getValidation(), testCase.getTest_cases());

                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    } else if (directories[j].isDirectory()) {
                        System.out.println("Directory " + directories[j].getName());


                    }
                }
            }
        }
    }

    public static void createTest(String uri, String path, String validation, List<testCase.foo> tests) {

        for (testCase.foo foo : tests) {
            RestAssured.reset();
            RestAssured.basePath = path;
            RestAssured.baseURI = uri;

//        if type "GET" then
//            get(String.format("%s?api_key=%s", foo.getQuery(), validation)).then().log().ifValidationFails().body(foo.getResponse_route(), equalTo(foo.getExpected()));
            get(String.format("%s?api_key=%s", foo.getQuery(), validation)).then().body(foo.getResponse_route(), equalTo(foo.getExpected()));


//        else if type "PUT" then
//          put(String.format("%s?api_key=%s", foo.getQuery(), validation)).then().body(foo.getResponse_route(), equalTo(foo.getExpected()));

//        else if type "POST" then
//          post(String.format("%s?api_key=%s", foo.getQuery(), validation)).then().body(foo.getResponse_route(), equalTo(foo.getExpected()));

//        else
//          delete(String.format("%s?api_key=%s", foo.getQuery(), validation)).then().body(foo.getResponse_route(), equalTo(foo.getExpected()));

//        return test;
        }
    }
}