package channelpopularity.context;

import channelpopularity.state.StateName;
import channelpopularity.util.data.Properties;
import channelpopularity.util.exception.NegativeLikesOrDislikes;
import channelpopularity.util.exception.NegativeValueOfViews;
import channelpopularity.util.exception.VideoAlreadyExists;
import channelpopularity.util.exception.VideoNotFound;
import java.util.Map;

public interface ContextI {

  /**
   * Interace to ChannelContext class which is used to keep account of which
   * channel are we processing for
   * 
   * @author - Rohit Mahendra Dhuri
   */

  /**
   * This function changes the state. Called by the States based on their logic of
   * what the machine state should change to
   * 
   * @param - The state which is supposed to be set, a StateName enum
   */
  public void setCurrentState(StateName nextState);

  /**
   * This function returns the current state.
   * 
   */
  public StateName getCurrentState();

  /**
   * This function returns the hashmap which contains all the details for any
   * video
   * 
   * @param - Hashmap that holds a string value for the video name and an objecgt
   *          of Properties for that video
   */
  public Map<String, Properties> getVideoData();

  /**
   * This function recalculates average popularity.
   * 
   */
  void updateChannelPopularity();

  /**
   * This function decides which state to switch to upon the popularity of the
   * channel.
   * 
   */
  void updateState();

  /**
   * Adds the video
   * 
   * @param - String containing the name of a video
   */
  public void addVideo(String vName) throws VideoAlreadyExists;

  /**
   * This function removes a video
   * 
   * @param - Name of the video to be removed
   */
  public void removeVideo(String vName) throws VideoNotFound;

  /**
   * This function updates the metrics of any video
   * 
   * @param - A string containing name of video and three integer values: views,
   *          likes and dislikes
   */
  public void metrics(String vName, Integer views, Integer likes, Integer dislikes)
      throws NegativeValueOfViews, NegativeLikesOrDislikes, VideoNotFound;

  /**
   * This function accepts or rejects an add request
   * 
   * @param - A string containing the video name and an interger for length
   */
  public void adRequest(String vName, Integer length);

}
