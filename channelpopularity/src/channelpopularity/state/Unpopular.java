package channelpopularity.state;
import channelpopularity.util.VideoProperties;
import channelpopularity.context.ContextI;

public class Unpopular extends VideoProperties implements StateI{

    private ContextI channelCObj;

    public Unpopular(ContextI inChannelCObj){
        channelCObj = inChannelCObj;
        
    }

    @Override
    public void addVideo(String vName){
        
        if(channelCObj.getVideoData().containsKey(vName)){
            //THROWS EXCEPTION
            System.out.println("Video "+ vName + " already exists.");
            System.exit(0);
        }else{
            channelCObj.setVideoData(vName, new VideoProperties());
        }

    }
    @Override
    public void removeVideo(){}
    @Override
    public void adRequest(){}
    @Override
    public void metrics(){}


}