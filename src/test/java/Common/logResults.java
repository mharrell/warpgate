//        Created by Mike Harrell 12.2.2017
//        Last updated by Mike Harrell on 12.2.2017
//        This file houses the class to provide readable test results to the user


package Common;

public class logResults {

    public static int fail = 0, pass = 0;

    public static void initTestRun(){
        System.out.println("---Beginning Test Setup---\n" +
                           "---Gathering Test Scenarios---");
    }

    //method to send the total test results to the console at the end of the run
    public static void showResults(){
        System.out.println("\n---Testing Has Concluded---\n");
        System.out.println("Tests run: " + (fail + pass));
        System.out.println("Tests passed: " + pass);
        System.out.println("Tests failed: " + fail);
    }

    //method to send the individual test results to the console and increment the number of failed tests.
    public static void logTestScenario(String suite_name, String scenario, String scenario_description){

        System.out.println(String.format("\nDirectory: %s - File: %s - %s", suite_name, scenario, scenario_description));
    }

    //method to send the individual test results to the console and increment the number of failed tests.
    public static void logFailure(String id, String description){
        fail++;
        System.out.println(String.format("FAILED: Test %s - %s", id, description));

    }

    //method to send the individual test results to the console and increment the number of passed tests.
    public static void logPassing(String id, String description){
        pass++;
        System.out.println(String.format("PASSED: Test %s - %s", id, description));
    }


}
