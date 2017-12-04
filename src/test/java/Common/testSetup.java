package Common;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import java.io.File;
import java.io.IOException;
import java.lang.System;
import java.util.List;
import static io.restassured.RestAssured.get;
import static org.hamcrest.core.IsEqual.equalTo;


public class testSetup {

    public static void testStartup() {

        System.out.println("---Beginning Test Setup---");
        System.out.println("---Gathering Test Scenarios---");

        //TODO: Figure out how to just use the relative path.
        File folder = new File("/Users/mharrell/IdeaProjects/warpgate/src/test/java/TestCases");


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


                        try {
                            testCase testCase = objectMapper.readValue(new File(directories[j].getPath()), testCase.class);

                            standupTest(testCase.getUri(), testCase.getPath(), testCase.getValidation(), testCase.getTest_cases());

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

    public static void standupTest(String uri, String path, String validation, List<testCase.body> tests) {

        for (testCase.body test : tests) {
            RestAssured.reset();
            RestAssured.basePath = path;
            RestAssured.baseURI = uri;

                try {
                    executeTest(validation, test);
                    logResults.logPassing(String.format("PASSED: Test %s - %s", test.getId(), test.getDescription()));
                }
                catch (AssertionError assertionError) {
                logResults.logFailure((String.format("FAILED: Test %s - %s", test.getId(), test.getDescription())));
                }
            }
        }

    public static void executeTest(String validation, testCase.body test){


//        if (body.getType() == "GET")
            get(String.format("%s?api_key=%s", test.getQuery(), validation)).then().body(test.getResponse_route(), equalTo(test.getExpected()));

//        else if type "PUT" then
//          put(String.format("%s?api_key=%s", body.getQuery(), validation)).then().body(body.getResponse_route(), equalTo(body.getExpected()));

//        else if type "POST" then
//          post(String.format("%s?api_key=%s", body.getQuery(), validation)).then().body(body.getResponse_route(), equalTo(body.getExpected()));

//        else
//          delete(String.format("%s?api_key=%s", body.getQuery(), validation)).then().body(body.getResponse_route(), equalTo(body.getExpected()));

//        return test;
        }
    }
