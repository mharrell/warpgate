//        Created by Mike Harrell 12.2.2017
//        Last updated by Mike Harrell on 12.2.2017
//        This file houses the test case workflow including parsing, setup, validation, and teardown.

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

        //Create File[] at the directory of the test files
        //TODO: Figure out how to just use the relative path.
        File folder = new File("/Users/mharrell/IdeaProjects/warpgate/src/test/java/TestCases");
        File[] listOfFiles = folder.listFiles();
        ObjectMapper objectMapper = new ObjectMapper();

        //Double loop to search for tests through each folder
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
            } else if (listOfFiles[i].isDirectory()) {
                File[] directories = listOfFiles[i].listFiles();

                for (int j = 0; j < directories.length; j++) {
                    if (directories[j].isFile()) {

        //Pull test steps from the test JSON files and create a list of testCase objects
                        try {
                            testCase testCase = objectMapper.readValue(new File(directories[j].getPath()), testCase.class);
        //Call standupTest, passing in the list of testCases
                            standupTest(testCase.getSuite_name(), testCase.getScenario(), testCase.getScenario_description(),
                                    testCase.getUri(), testCase.getPath(), testCase.getValidation(), testCase.getTest_cases());

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
    //Using data from the testCase, set API query params and then execute each test step.
    public static void standupTest(String suite_name, String scenario, String scenario_description, String uri,
                                   String path, String validation, List<testCase.body> tests) {

        logResults.logTestScenario(suite_name, scenario, scenario_description);

        for (testCase.body test : tests) {
            RestAssured.reset();
            RestAssured.basePath = path;
            RestAssured.baseURI = uri;


            //execute test steps here, logResults is called for each pass or fail
                try {
                    executeTest(validation, test);
                    logResults.logPassing(test.getId(), test.getDescription());
                }
                catch (AssertionError assertionError) {
                    logResults.logFailure(test.getId(), test.getDescription());
                }
            }
        }

    //Using data from the each test step, a Rest Assured statment is built and executed
    public static void executeTest(String validation, testCase.body test){


//        if (body.getType() == "GET")
            get(String.format("%s?api_key=%s", test.getQuery(), validation)).then().body(test.getResponse_route(), equalTo(test.getExpected()));

//        else if type "PUT" then
//          put(String.format("%s?api_key=%s", body.getQuery(), validation)).then().body(body.getResponse_route(), equalTo(body.getExpected()));

//        else if type "POST" then
//          post(String.format("%s?api_key=%s", body.getQuery(), validation)).then().body(body.getResponse_route(), equalTo(body.getExpected()));

//        else
//          delete(String.format("%s?api_key=%s", body.getQuery(), validation)).then().body(body.getResponse_route(), equalTo(body.getExpected()));

        }
    }
