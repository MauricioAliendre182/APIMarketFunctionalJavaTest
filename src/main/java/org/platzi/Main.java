package org.platzi;

import com.beust.jcommander.JCommander;
import org.platzi.api.APIJobs;
import org.platzi.api.Client;
import org.platzi.cli.CLIArguments;
import org.platzi.cli.CLIFunctions;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static org.platzi.CommanderFunctions.buildCommanderWithName;
import static org.platzi.CommanderFunctions.parseArguments;
import static org.platzi.api.APIFunctions.buildAPI;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        JCommander jCommander = buildCommanderWithName("client-search", CLIArguments::newInstance);
        // What we want to receive?
        Stream<CLIArguments> streamCLI =
                // JCommander::usage is to show the help, case that we did not put a correct option
                parseArguments(jCommander, args, JCommander::usage)
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(obj -> (CLIArguments) obj);
        Optional<CLIArguments> cliArgumentsOptional = streamCLI
                .filter(cli -> !cli.isHelp())
//                .filter(cli -> cli.getId() != null)
                .findFirst();

        // Convert this CLIArguments to something that can be used in the URL
        cliArgumentsOptional.map(CLIFunctions::toMap)
                .map(Main::executeRequest)
                .orElse(Stream.empty())
                .forEach(System.out::println);
        }
    private static Stream<Client> executeRequest(Map<String, Object> params) {
        // Transform this object and make the request
        APIJobs api = buildAPI(APIJobs.class, "http://localhost:8090/");
        return Stream.of(params)
                .map(api::clients)
                .flatMap(Collection::stream);
    }
}