package stringArgsConverters;

import com.beust.jcommander.IStringConverter;

public class LimitSpeedConverter implements IStringConverter{

    @Override
    public Integer convert(String value) {

        if(value.charAt(value.length()-1)=='m') return Integer.parseInt(value.substring(0,value.length()-1))*1024*1024;
        else if (value.charAt(value.length()-1)=='k') return Integer.parseInt(value.substring(0,value.length()-1))*1024;
        else return Integer.parseInt(value);

    }
}
