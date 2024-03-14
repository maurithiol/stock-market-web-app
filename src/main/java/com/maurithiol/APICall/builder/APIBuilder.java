package com.maurithiol.APICall.builder;

import java.util.ArrayList;
import java.util.List;

public class APIBuilder {
    private final String API_KEY = "d3a872a32b9a41f2a04f088d093444a8";
    private String prefix;
    private List<APIArgs> args;

    public APIBuilder(String prefix) {
        this.prefix = prefix;
        this.args = new ArrayList<>();
    }

    public void addArgument(String name, String value) {
        APIArgs arg = new APIArgs(name, value);
        args.add(arg);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(prefix);
        result.append("&apikey=" + API_KEY);
        for (APIArgs arg : args) {
            result.append("&" + arg.getName() + "=" + arg.getValue());
        }
        return result.toString();
    }

    private class APIArgs {
        private String name;
        private String value;

        private APIArgs(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }
    }
}
