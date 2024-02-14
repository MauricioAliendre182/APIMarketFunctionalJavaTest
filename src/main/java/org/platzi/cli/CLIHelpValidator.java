package org.platzi.cli;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class CLIHelpValidator implements IParameterValidator {
    @Override
    public void validate(String name, String value) throws ParameterException {
        // name refers to what we have written in our terminal
        boolean actualValue = Boolean.parseBoolean(value);
        if (actualValue) {
            throw new ParameterException("Help requested");
        }
    }
}
