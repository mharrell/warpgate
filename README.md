# warpgate
Test Framework Homework Assignment

This is an automated REST test framework intended to be usable for any api.

Some tests have been included as examples. They are intended to used on The Movie Database (www.themoviedb.org) API. Some of the example tests will intentionally fail as a demonstration.

How it works:
Tests are written as a JSON file using standard values as follows (NOTE: the user will have to supply their own TMDB API key for the tests to run correctly): 

{
  "suite_name": ,
  "scenario": ,
  "scenario_description": ,
  "uri": ,
  "path": ,
  "validation": "",
 
 Each step is then written under the test_cases value.
  
  "test_cases": [
    {
      "id": ,
      "description": ,
      "type": ,
      "query": ,
      "response_route": ,
      "expected":
    }
  ]
}

The values of the JSON are parsed out and used to construct test objects which are then used to generate Rest Assured queries. After a  step is validated, the result is sent to the console. This continues until all files in all test directories have been executed.

Getting Started:
Step 1: For the sake of this example. A valid TMDB API key must be inserted as a string (in quotes) to the validation value in each JSON file.
Step 2: Run a maven install.
Step 3: Run the Runner.main() method in Runner.java.

Possibilities for future development. 
 - Add functionality for more methods than GET.
 - Add functionality for more validation options.
 - Add functionality to accommodate more complex Rest Assured queries, including given() and when().

