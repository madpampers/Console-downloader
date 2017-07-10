import checkArgs.CheckSourceFile;
import checkArgs.CheckThreadsNumber;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import stringArgsConverters.FileConverter;

import java.io.File;

public class ConsoleDownloader {

    @Parameter(names="-n", validateWith = CheckThreadsNumber.class)
    int threadsNumber = 1;
    @Parameter(names={"-o"})
    String destFolder;
    @Parameter(names={"-l"})
    int limitSpeed;
    @Parameter(names="-f", validateWith = CheckSourceFile.class, converter = FileConverter.class)
    File sourceFile;

    public static void main(String[] args) {
        ConsoleDownloader main = new ConsoleDownloader();
        JCommander.newBuilder()
                .addObject(main)
                .build()
                .parse(args);
        main.run();
    }

    public void run() {
        System.out.printf("%d %s %s %s", threadsNumber, destFolder, limitSpeed, sourceFile);
    }

}
