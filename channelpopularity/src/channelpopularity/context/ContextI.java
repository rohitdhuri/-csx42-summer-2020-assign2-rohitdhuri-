package channelpopularity.context;
import channelpopularity.state.StateName;
import channelpopularity.state.StateI;
import channelpopularity.util.VideoProperties;
import java.util.Map;

public interface ContextI {
    public void setCurrentState(StateName nextState);
    public void setVideoData(String vName, VideoProperties vp);
    public Map<String, VideoProperties> getVideoData();


}
