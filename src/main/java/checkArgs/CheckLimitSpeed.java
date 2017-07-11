package checkArgs;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class CheckLimitSpeed implements IParameterValidator {

    @Override
    public void validate(String name, String value) throws ParameterException {

        if (value.charAt(value.length()-1)!='m'&&value.charAt(value.length()-1)!='k'){
            try{
                if(Integer.parseInt(value)<1)
                    throw new ParameterException ("Incorrect download speed limit parameter (found " + value +")");
            }
            catch (Exception e) {
                throw new ParameterException ("Incorrect download speed limit parameter (found " + value +")");
            }
        }

        if(value.charAt(value.length()-1)=='m'||value.charAt(value.length()-1)=='k') {

            try{
                if(Integer.parseInt(value.substring(0,value.length()-1))<1)
                    throw new ParameterException ("Incorrect download speed limit parameter (found " + value +")");
            }
            catch (Exception e) {
                throw new ParameterException ("Incorrect download speed limit parameter (found " + value +")");
            }

        }

    }
}
