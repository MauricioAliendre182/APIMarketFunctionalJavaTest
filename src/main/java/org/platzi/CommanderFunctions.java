package org.platzi;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CommanderFunctions {
    static <T> JCommander buildCommanderWithName(String cliName, Supplier<T> argumentSupplier){
        JCommander jCommander = JCommander.newBuilder()
                .addObject(argumentSupplier.get())
                .build();

        jCommander.setProgramName(cliName);
        return jCommander;

    }

    static Optional<List<Object>> parseArguments(JCommander jCommander, String[] arguments, Consumer<JCommander> onError) {
        // We need to catch the ParameterException that we have configured in
        // CLIHelpValidator and CLIIdValidator
        try {
            jCommander.parse(arguments);
            return Optional.of(jCommander.getObjects());
        } catch (ParameterException e) {
            onError.accept(jCommander);
        }
        return Optional.empty();
    }
}
