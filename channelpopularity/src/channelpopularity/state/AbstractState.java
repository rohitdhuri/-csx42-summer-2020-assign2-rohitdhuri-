package channelpopularity.state;

import channelpopularity.context.ChannelContext;
import channelpopularity.util.Results;
import channelpopularity.util.data.Properties;
import channelpopularity.util.exception.NegativeLikesOrDislikes;
import channelpopularity.util.exception.NegativeValueOfViews;
import channelpopularity.util.exception.VideoAlreadyExists;
import channelpopularity.util.exception.VideoNotFound;

public abstract class AbstractState implements StateI {

    /**
     * Class AbstractState Defines the common operations for each state
     * 
     * @author - Rohit Mahendra Dhuri
     */

    /**
     * Adds the video
     * 
     * @param - String containing the name of a video, ChannelConetxt object and
     *          results object
     */
    @Override
    public void addVideo(String vName, ChannelContext c, Results result) throws VideoAlreadyExists {
        result.storeOutput(c.getCurrentState() + "__VIDEO_ADDED::" + vName + "\n");
        if (c.getVideoData().containsKey(vName)) {
            throw new VideoAlreadyExists("Video added is already present");
        } else {
            c.getVideoData().put(vName, new Properties());
        }
        c.updateChannelPopularity();
        c.updateState();

    }

    /**
     * This function removes a video
     * 
     * @param - Name of the video to be removed, ChannelConetxt object and results
     *          object
     */
    @Override
    public void removeVideo(String vName, ChannelContext c, Results result) throws VideoNotFound {
        result.storeOutput(c.getCurrentState() + "__VIDEO_REMOVED::" + vName + "\n");
        if (c.getVideoData().containsKey(vName)) {
            c.getVideoData().remove(vName);
        } else {
            throw new VideoNotFound("Video being asked to remove does not exist");
        }
        c.updateChannelPopularity();
        c.updateState();
    }

    /**
     * This function updates the metrics of any video
     * 
     * @param - A string containing name of video and three integer values: views,
     *          likes and dislikes. Also ChannelConetxt object and results object.
     */
    @Override
    public void metrics(String vName, Integer views, Integer likes, Integer dislikes, ChannelContext c, Results result)
            throws NegativeValueOfViews, NegativeLikesOrDislikes, VideoNotFound {

        if (views < 0) {
            throw new NegativeValueOfViews("Negative value for number of views in an input line");
        }

        if (c.getVideoData().containsKey(vName)) {
            c.getVideoData().get(vName).set(views, likes, dislikes);
            c.getVideoData().get(vName).calPopularityScoreVideo();
        } else {
            throw new VideoNotFound("Video associated with an advertisement request does not exist");
        }

        c.updateChannelPopularity();
        result.storeOutput(c.getCurrentState() + "__POPULARITY_SCORE_UPDATE::" + c.channelPopularityScore + "\n");
        c.updateState();

    }

    @Override
    public String toString() {
        return "Class: AbstractState, Data Members: [ ]";
    }

}
