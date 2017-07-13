import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class SrcFileParser {

    private final File sourcefile;
    private ArrayList<URL> listUrls;
    private ArrayList<String> listFileNames;

    SrcFileParser(final File sourceFile) {

        this.sourcefile = sourceFile;
        listUrls = new ArrayList<>();
        listFileNames = new ArrayList<>();

    }

    void formLists() {

        String [] lines = readFile().split(" ");
        for(int i = 0; i < lines.length; i++){
            if (i%2==0) try {
                System.out.println(lines[i]);
                listUrls.add(new URL(lines[i]));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            else listFileNames.add(lines[i]);
        }

    }

    ArrayList<URL> getListUrls() {
        return listUrls;
    }

    ArrayList<String> getListFileNames() {
        return listFileNames;
    }

    private String readFile() {
        String content = null;
        FileReader reader = null;
        try {
            reader = new FileReader(sourcefile);
            char[] chars = new char[(int) sourcefile.length()];
            reader.read(chars);
            content = new String(chars);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return content;

    }
}
