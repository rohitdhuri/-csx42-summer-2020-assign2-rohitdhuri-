package channelpopularity.context;

import channelpopularity.state.factory.SimpleStateFactoryI;
import channelpopularity.state.StateName;
import channelpopularity.state.StateI;
import channelpopularity.util.data.Properties;
import channelpopularity.util.exception.NegativeValueOfViews;
import channelpopularity.util.exception.VideoAlreadyExists;
import channelpopularity.util.exception.VideoNotFound;
import channelpopularity.util.exception.NegativeLikesOrDislikes;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import channelpopularity.util.Results;

public class ChannelContext implements ContextI {

    /**
     * ChannelContext class is used to keep account of which channel are we
     * processing for
     * 
     * @author - Rohit Mahendra Dhuri
     */

    private StateI curState;
    private Map<StateName, StateI> availableStates;
    private Map<String, Properties> videoData;
    public Integer channelPopularityScore;
    public Results result;

    /**
     * ChannelContext constructor which initializes the hashmaps availableStates and
     * videoData also fills up the availableStates hashmap using stateFactory
     * initialize states using factory instance and the provided state names.
     * initialize current state.
     * 
     * @param - StateFactory object,List of Statenames and an objecxt of results
     *          class
     */
    public ChannelContext(SimpleStateFactoryI stateFactoryIn, List<StateName> stateNames, Results inResult) {

        availableStates = new HashMap<StateName, StateI>();
        videoData = new HashMap<String, Properties>();

        result = inResult;
        for (final StateName state : stateNames) {
            availableStates.put(state, stateFactoryIn.create(state));
        }

        curState = availableStates.get(StateName.UNPOPULAR);
    }

    /**
     * This function changes the state. Called by the States based on their logic of
     * what the machine state should change to
     * 
     * @param - The state which is supposed to be set, a StateName enum
     */
    public void setCurrentState(final StateName nextState) {
        if (availableStates.containsKey(nextState)) { // for safety.
            curState = availableStates.get(nextState);
        }
    }

    /**
     * This function returns the current state.
     * 
     */
    public StateName getCurrentState() {
        for (Map.Entry<StateName, StateI> entry : availableStates.entrySet()) {
            if (entry.getValue().equals(curState)) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * This function recalculates average popularity.
     * 
     */
    public void updateChannelPopularity() {
        int sum = 0, i = 0;
        for (Map.Entry<String, Properties> entry : videoData.entrySet()) {
            sum += entry.getValue().popularityScore;
            i++;
        }
        if (i > 0) {
            channelPopularityScore = sum / i;
        } else {
            channelPopularityScore = 0;
        }
    }

    /**
     * This function decides which state to switch to upon the popularity of the
     * channel.
     * 
     */
    public void updateState() {

        if (channelPopularityScore >= 0 && channelPopularityScore <= 1000) {
            setCurrentState(StateName.UNPOPULAR);
        } else if (channelPopularityScore >= 1000 && channelPopularityScore <= 10000) {
            setCurrentState(StateName.MILDLY_POPULAR);
        } else if (channelPopularityScore >= 10001 && channelPopularityScore <= 100000) {
            setCurrentState(StateName.HIGHLY_POPULAR);
        } else if (channelPopularityScore >= 100001 && channelPopularityScore <= Integer.MAX_VALUE) {
            setCurrentState(StateName.ULTRA_POPULAR);
        } else {
        }
    }

    /**
     * This function returns the hashmap which contains all the details for any
     * video
     * 
     * @param - Hashmap that holds a string value for the video name and an objecgt
     *          of Properties for that video
     */
    public Map<String, Properties> getVideoData() {
        return videoData;
    }

    /**
     * Adds the video
     * 
     * @param - String containing the name of a video
     */
    public void addVideo(final String vName) throws VideoAlreadyExists {
        curState.addVideo(vName, this, result);
    }

    /**
     * This function removes a video
     * 
     * @param - Name of the video to be removed
     */
    public void removeVideo(final String vName) throws VideoNotFound {
        curState.removeVideo(vName, this, result);
    }

    /**
     * This function accepts or rejects an add request
     * 
     * @param - A string containing the video name and an interger for length
     */
    public void adRequest(String vName, Integer length) {
        curState.adRequest(vName, length, this, result);
    }

    /**
     * This function updates the metrics of any video
     * 
     * @param - A string containing name of video and three integer values: views,
     *          likes and dislikes
     */
    public void metrics(final String vName, final Integer views, final Integer likes, final Integer dislikes)
            throws NegativeValueOfViews, NegativeLikesOrDislikes, VideoNotFound {
        curState.metrics(vName, views, likes, dislikes, this, result);

    }

}