package channelpopularity.state;
import channelpopularity.util.VideoProperties;
import channelpopularity.context.ContextI;

public class HighlyPopular implements StateI{
    
    private ContextI channelCObj;

    public HighlyPopular(ContextI inChannelCObj){
        channelCObj = inChannelCObj;
        
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