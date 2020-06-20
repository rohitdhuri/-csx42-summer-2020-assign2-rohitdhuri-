package channelpopularity.state;
import channelpopularity.util.VideoProperties;
import channelpopularity.util.data.VideoData;
import channelpopularity.context.ContextI;

public class MildlyPopular implements StateI{
    
    private ContextI channelCObj;
    private VideoData vd;

    public MildlyPopular(ContextI inChannelCObj, VideoData inVd){
        channelCObj = inChannelCObj;
        vd = inVd;
    }
    
    @Override
    public void addVideo(String vName){}
    @Override
    public void removeVideo(){}
    @Override
    public void adRequest(){}
    @Override
    public void metrics(){}

}