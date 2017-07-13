import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

public class DownloadController extends Thread {

    private ArrayList<URL> listUrls;
    private ArrayList<String> listFileNames;
    private DownloadThreads[] threadArr;
    private String destFolder;
    private int count = 0;
    private int bytes = 0;

    private String timeSpent;

    DownloadController(final ArrayList<URL> listUrls,
                       final ArrayList<String> listFileNames,
                       int threadsNumber,
                       final String destFolder) {

        this.listUrls = listUrls;
        this.listFileNames = listFileNames;
        this.threadArr = new DownloadThreads[threadsNumber];
        this.destFolder = destFolder;

    }

    @Override
    public void run() {

        long start = (new Date()).getTime();

        while (count < listUrls.size()) {
            for (int i = 0; i < threadArr.length; i++) {
                if ((threadArr[i] == null || !(threadArr[i].isAlive())) && count < listUrls.size()) {
                    threadArr[i] = new DownloadThreads(getNextUrl(count), getNextFileName(count), destFolder);
                    threadArr[i].start();
                    System.out.println("запустили поток " + i);
                    count++;
                }
            }

        }

        for (Thread th : threadArr) {
            try {
                th.join();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }

        long finish = (new Date()).getTime();

        timeSpent=calculateTimeSpent(start, finish);

    }

    private String calculateTimeSpent(long start, long finish) {
        StringBuilder builder = new StringBuilder();
        long timeSpent = finish - start;
        builder.append(timeSpent/1000/60/60)
                .append("h")
                .append(timeSpent/1000/60)
                .append("m")
                .append(timeSpent/1000)
                .append("s");
        return builder.toString();
    }

    private URL getNextUrl(int count) {
        return listUrls.get(count);
    }

    private String getNextFileName(int count) {
        return listFileNames.get(count);
    }

    public String getTimeSpent() {
        return timeSpent;
    }

}
