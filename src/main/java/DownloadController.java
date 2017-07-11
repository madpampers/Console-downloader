import java.util.ArrayList;

public class DownloadController {

    public ArrayList<DownloadThread> getListThreads() {
        return listThreads;
    }

    ArrayList<DownloadThread> listThreads;

    public DownloadController(ArrayList<DownloadThread> listThreads) {

        this.listThreads = listThreads;

    }

    public boolean initNewThread(String key, String value){

    }

    private void nextCurrents() {
    }

}
