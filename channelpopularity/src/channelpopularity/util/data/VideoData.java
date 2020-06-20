package channelpopularity.util.data;
import java.util.Map;
import java.util.HashMap;
import channelpopularity.util.data.Properties;

public class VideoData {


    private Map<String, Properties> videoData = new HashMap<String, Properties>();


    public void addVideo(String vName){
        videoData.put(vName, new Properties());
        System.out.println("\n videos hashmap "+ videoData);
    }

    public void setMetrics(String vName, int views, int likes, int dislikes){
        Properties p = videoData.get(vName);
        p.set(views, likes, dislikes);
    }

    public Map<String, Properties> getVideoData(){
        return videoData;
    }
}