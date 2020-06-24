package channelpopularity.state;

import channelpopularity.context.ChannelContext;
import channelpopularity.util.Results;
import channelpopularity.util.exception.NegativeLikesOrDislikes;
import channelpopularity.util.exception.NegativeValueOfViews;
import channelpopularity.util.exception.VideoAlreadyExists;
import channelpopularity.util.exception.VideoNotFound;

public interface StateI {

    /**
     * Class StateI acts as an interface to all states including th abstract state
     * 
     * @author - Rohit Mahendra Dhuri
     */


    /**
     * Adds the video
     * 
     * @param - String containing the name of a video, ChannelConetxt object and
     *          results object
     */
    void addVideo(String vName, ChannelContext c, Results result) throws VideoAlreadyExists;

    /**
     * This function removes a video
     * 
     * @param - Name of the video to be removed, ChannelConetxt object and results
     *          object
     */
    void removeVideo(String vName, ChannelContext c, Results result) throws VideoNotFound;

    /**
     * This function accepts or rejects an add request
     * 
     * @param - A string containing the video name, an interger for length,
     *          ChannelConetxt object and results object
     */
    void adRequest(String vName, Integer length, ChannelContext c, Results result);

    /**
     * This function updates the metrics of any video
     * 
     * @param - A string containing name of video and three integer values: views,
     *          likes and dislikes. Also ChannelConetxt object and results object.
     */
    void metrics(String vName, Integer views, Integer likes, Integer dislikes, ChannelContext c, Results result)
            throws NegativeValueOfViews, NegativeLikesOrDislikes, VideoNotFound;

}
