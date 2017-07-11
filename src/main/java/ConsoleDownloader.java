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
import java.util.ArrayList;
import java.util.Map;

public class ConsoleDownloader {

    @Parameter(names="-n", validateWith = CheckThreadsNumber.class)
    private static int threadsNumber;
    @Parameter(names="-o", validateWith = CheckDestFolder.class, converter = DestFolderConverter.class)
    private static String destFolder;
    @Parameter(names="-l", validateWith = CheckLimitSpeed.class, converter = LimitSpeedConverter.class)
    private static int limitSpeed;
    @Parameter(names="-f", validateWith = CheckSourceFile.class, converter = FileConverter.class)
    private static File sourceFile;

    public static void main(String[] args) {
        ConsoleDownloader main = new ConsoleDownloader();
        JCommander.newBuilder()
                .addObject(main)
                .build()
                .parse(args);
        main.run();
    }

    public void run() {

        DownloadController start = new DownloadController(new ArrayList<>());
        SourceFileParser sourceFileMap = new SourceFileParser();

        while(start.getListThreads().size()!=0){
            for(Map.Entry<String, String> entry:sourceFileMap.parsedMap.entrySet()) {
                start.initNewThread(entry.getKey(), entry.getValue());
            }
        }

    }

}
