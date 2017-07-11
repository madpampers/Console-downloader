import checkArgs.CheckDestFolder;
import checkArgs.CheckLimitSpeed;
import checkArgs.CheckSourceFile;
import checkArgs.CheckThreadsNumber;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import stringArgsConverters.DestFolderConverter;
import stringArgsConverters.FileConverter;
import stringArgsConverters.LimitSpeedConverter;

import java.io.File;

public class ConsoleDownloader {

    @Parameter(names="-n", validateWith = CheckThreadsNumber.class)
    private int threadsNumber;
    @Parameter(names="-o", validateWith = CheckDestFolder.class, converter = DestFolderConverter.class)
    private String destFolder;
    @Parameter(names="-l", validateWith = CheckLimitSpeed.class, converter = LimitSpeedConverter.class)
    private int limitSpeed;
    @Parameter(names="-f", validateWith = CheckSourceFile.class, converter = FileConverter.class)
    private File sourceFile;

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
