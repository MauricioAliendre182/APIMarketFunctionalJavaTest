package org.platzi.cli;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class CLIIdValidator implements IParameterValidator {
    @Override
    public void validate(String name, String value) throws ParameterException {
        if (!value.matches("^[0-9]+[0-9]*$")) {
            System.err.println("The search criteria is not valid");
            throw new ParameterException("Uniquely numbers please!");
        }
    }
}
