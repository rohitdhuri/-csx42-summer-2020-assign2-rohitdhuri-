package channelpopularity.util.data;
import java.util.Map;
import java.util.HashMap;
import channelpopularity.util.data.Properties;

public class VideoData {

    private Map<String, Properties> videoData = new HashMap<String, Properties>();
    private Properties p;

    public void addVideo(String vName) {
        videoData.put(vName, new Properties());
        System.out.println("\n videos hashmap " + videoData);
    }

    public void removeVideo(String vName){
        videoData.remove(vName);
        System.out.println("\n videos hashmap " + videoData);
    }


    public void setMetrics(String vName, int views, int likes, int dislikes) {
        p = null;
        p = videoData.get(vName);
        if(p==null)
        {
            System.out.println("Video dosent exist");
            System.exit(0);
        }

        p.set(views, likes, dislikes);
        p.calPopularityScore();
        System.out.println(p.views +" "+ p.likes +" "+ p.dislikes +" "+ p.popularityScore);
    }

    public int getPopularityScore(String vName)
    {   
        p = videoData.get(vName);
       return p.popularityScore;
    }

    public Map<String, Properties> getVideoData() {
        return videoData;
    }
}