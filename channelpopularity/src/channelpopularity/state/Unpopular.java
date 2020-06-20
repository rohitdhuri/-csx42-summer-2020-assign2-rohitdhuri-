package channelpopularity.state;
//import channelpopularity.util.data.Properties;
import channelpopularity.context.ContextI;
import channelpopularity.util.data.VideoData;


public class Unpopular implements StateI{

    private ContextI channelCObj;
    private VideoData vd;

    public Unpopular(ContextI inChannelCObj, VideoData inVd) {
        channelCObj = inChannelCObj;
        vd = inVd;
        
    }

    @Override
    public void addVideo(String vName){
        
        if(vd.getVideoData().containsKey(vName)){
            //THROWS EXCEPTION
            System.out.println("Video "+ vName + " already exists.");
            System.exit(0);
        }else{
                vd.addVideo(vName);
            //channelCObj.setVideoData(vName, new VideoProperties());
        }

    }
    @Override
    public void removeVideo(){}
    @Override
    public void adRequest(){}
    @Override
    public void metrics(){}


}