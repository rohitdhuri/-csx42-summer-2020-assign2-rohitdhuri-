package channelpopularity.context;

import channelpopularity.state.StateName;
import channelpopularity.util.data.Properties;
import channelpopularity.util.exception.NegativeLikesOrDislikes;
import channelpopularity.util.exception.NegativeValueOfViews;
import channelpopularity.util.exception.VideoAlreadyExists;
import channelpopularity.util.exception.VideoNotFound;
import java.util.Map;

public interface ContextI {
  public void setCurrentState(StateName nextState);

  public StateName getCurrentState();

  // public void setVideoData(String vName, Properties vp);
  // public Map<String, Properties> getVideoData();
  public Map<String, Properties> getVideoData();

  void updateChannelPopularity();

  void updateState();

  public void addVideo(String vName) throws VideoAlreadyExists;

  public void removeVideo(String vName) throws VideoNotFound;

  public void metrics(String vName, Integer views, Integer likes, Integer dislikes) throws NegativeValueOfViews, NegativeLikesOrDislikes, VideoNotFound;

  public void adRequest(String vName, Integer length);

}
