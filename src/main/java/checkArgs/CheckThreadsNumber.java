package checkArgs;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class CheckThreadsNumber implements IParameterValidator {

    @Override
    public void validate(String name, String value)
            throws ParameterException {
        int n = Integer.parseInt(value);
        if (n < 0) {
            throw new ParameterException("Parameter " + name + " should be positive (found " + value +")");
        }

        if (n > 10) {
            throw new ParameterException("Maximum value of -n parameter is 10 (found " + value +")");
        }



    }

}
