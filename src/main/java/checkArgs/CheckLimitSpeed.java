package checkArgs;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class CheckLimitSpeed implements IParameterValidator {
    @Override
    public void validate(String name, String value) throws ParameterException {
        if (value.charAt(value.length()-1)!='m'&&value.charAt(value.length()-1)!='k'&&value.)
    }
}
