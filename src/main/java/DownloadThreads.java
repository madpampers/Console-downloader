import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class DownloadThreads extends Thread{

    private static URL nextUrl;
    private static String nextFileName;
    private static String destFolder;

    public DownloadThreads(URL nextUrl, String nextFileName, String destFolder) {

        DownloadThreads.nextFileName = nextFileName;
        DownloadThreads.nextUrl = nextUrl;
        DownloadThreads.destFolder = destFolder;

    }

    @Override
    public void run(){

        try {
            File file = new File(destFolder+"\\"+nextFileName);
            file.createNewFile();
            downloadFileFromURL(nextUrl.toString(), file);
        } catch (Throwable e) {
            e.printStackTrace();
        }



    }

    public static void downloadFileFromURL(String urlString, File destination) throws Throwable {

        URL website = new URL(urlString);
        try(
                ReadableByteChannel rbc = Channels.newChannel(website.openStream());
                FileOutputStream fos = new FileOutputStream(destination);
        ){
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }

    }

}
