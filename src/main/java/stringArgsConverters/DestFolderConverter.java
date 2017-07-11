package stringArgsConverters;

import com.beust.jcommander.IStringConverter;

public class DestFolderConverter implements IStringConverter<String> {
    @Override
    public String convert(String value) {
        return value.replaceAll("/", "\\\\");
    }
}
