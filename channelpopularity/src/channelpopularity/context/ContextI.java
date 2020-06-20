package channelpopularity.context;
import channelpopularity.state.StateName;
import channelpopularity.util.data.Properties;
import java.util.Map;

public interface ContextI {
    public void setCurrentState(StateName nextState);
  //  public void setVideoData(String vName, Properties vp);
  //  public Map<String, Properties> getVideoData();


}
