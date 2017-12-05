//        Created by Mike Harrell 12.2.2017
//        Last updated by Mike Harrell on 12.2.2017
//        This file houses the classes pull test parameters from scenario files and create testClass objects

package Common;

import java.util.ArrayList;
import java.util.List;

public class testCase {

    //Creates list of arrays using test JSON files
    //each array represents one test step.
    private String suite_name, scenario, scenario_description, uri, path, validation;
    private List<body>test_cases = new ArrayList<body>();

    public String getSuite_name() {
        return suite_name;
    }

    public void setSuite_name(String suite_name) {
        this.suite_name = suite_name;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public String getScenario_description() {
        return scenario_description;
    }

    public void setScenario_description(String scenario_description) {
        this.scenario_description = scenario_description;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }


    public List<body> getTest_cases() {
        return test_cases;
    }

    public void setTest_cases(List<body> test_cases) {
        this.test_cases = test_cases;
    }


    //constructor to create individual test step object using data pulled from test JSON file
    public static class body {
        private String id, description, type, query, response_route;
        private Object expected;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getQuery() {
            return query;
        }

        public void setQuery(String query) {
            this.query = query;
        }

        public String getResponse_route() {
            return response_route;
        }

        public void setResponse_route(String response_route) {
            this.response_route = response_route;
        }

        public Object getExpected() {
            return expected;
        }

        public void setExpected(Object expected) {
            this.expected = expected;
        }
    }
}
