package channelpopularity.context;

import channelpopularity.state.StateI;
import channelpopularity.state.StateName;
import channelpopularity.util.data.Properties;
import java.util.Map;

public interface ContextI {
    public void setCurrentState(StateName nextState);
    public StateName getCurrentState();

  //  public void setVideoData(String vName, Properties vp);
  //  public Map<String, Properties> getVideoData();
  public Map<String, Properties> getVideoData();

  public void addVideo(String vName);
  public void removeVideo(String vName);
  public void metrics(String vName, Integer views, Integer likes, Integer dislikes);
  public void adRequest(String vName, Integer length);
  void updateChannelPopularity();

}
