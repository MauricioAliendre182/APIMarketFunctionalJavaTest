package org.platzi.cli;

import java.util.HashMap;
import java.util.Map;

public class CLIFunctions {
    public static Map<String, Object> toMap(CLIArguments cliArguments) {
        Map<String, Object> params = new HashMap<>();
        params.put("description", cliArguments.getKeyword());
        params.put("IdClient", cliArguments.getId());
        params.put("full_time", cliArguments.isFullTime());
        params.put("page", cliArguments.getPage());

        if(cliArguments.isMarkdown()) {
            params.put("markdown", true);
        }

        return params;
    }
}
