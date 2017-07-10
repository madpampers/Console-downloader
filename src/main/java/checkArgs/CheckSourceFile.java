package checkArgs;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

import java.io.File;

public class CheckSourceFile implements IParameterValidator {

    @Override
    public void validate(String name, String value) throws ParameterException {

        File f = new File(value);
        if(!(f.exists() && f.isFile())) {
            throw new ParameterException("File " + value + " doesn't exist, or incorrect path to file");
        }
    }
}
