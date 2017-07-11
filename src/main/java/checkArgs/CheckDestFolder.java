package checkArgs;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CheckDestFolder implements IParameterValidator {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String ans;

    @Override
    public void validate(String name, String value) throws ParameterException {

        Path path = Paths.get(value);

        if (!Files.exists(path)) {
            try {

                System.out.println("Folder " + value + " doesn't exist, create?");



                if (noFolder().equals("Y")
                        || ans.equals("y")
                        || ans.equals("Yes")
                        || ans.equals("YES")) Files.createDirectories(path);

                else throw new ParameterException("Folder " + value + " doesn't exist.");


            } catch (IOException e) {
                throw new ParameterException("Incorrect path or folder name (found " + value +")");
            }
        }

    }

    private String noFolder() throws IOException {
        return ans = reader.readLine();

    }
}


