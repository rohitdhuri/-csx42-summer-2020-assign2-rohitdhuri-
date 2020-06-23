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
    private StateI curState;
    private Map<StateName, StateI> availableStates;
    private Map<String, Properties> videoData;
    public Integer channelPopularityScore;
    public Results result;
    // private Map<String, Properties> videoData;

    public ChannelContext(final SimpleStateFactoryI stateFactoryIn, final List<StateName> stateNames, Results inResult) {
        // initialize states using factory instance and the provided state names.
        // initialize current state.

        availableStates = new HashMap<StateName, StateI>();
        videoData = new HashMap<String, Properties>();

        result = inResult;
        // videoData = new HashMap<String, Properties>();
        for (final StateName state : stateNames) {
            availableStates.put(state, stateFactoryIn.create(state));
        }

        curState = availableStates.get(StateName.UNPOPULAR);
    }

    // Called by the States based on their logic of what the machine state should
    // change to.
    public void setCurrentState(final StateName nextState) {
        if (availableStates.containsKey(nextState)) { // for safety.
            curState = availableStates.get(nextState);
        }
    }

    public StateName getCurrentState() {
        for (Map.Entry<StateName, StateI> entry : availableStates.entrySet()) {
            if (entry.getValue().equals(curState)) {
                return entry.getKey();
            }
        }
        return null;
    }

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

    public void addVideo(final String vName) throws VideoAlreadyExists {
        curState.addVideo(vName, this, result);
    }

    public void removeVideo(final String vName) throws VideoNotFound {
        curState.removeVideo(vName, this, result);
    }

    public void adRequest(String vName, Integer length) {
        curState.adRequest(vName, length, this, result);
    }

    public void metrics(final String vName, final Integer views, final Integer likes, final Integer dislikes) throws NegativeValueOfViews, NegativeLikesOrDislikes, VideoNotFound{
        curState.metrics(vName, views, likes, dislikes, this, result);

    }

    public Map<String, Properties> getVideoData() {
        return videoData;
    }

}