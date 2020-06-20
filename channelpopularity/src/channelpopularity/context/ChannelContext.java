package channelpopularity.context;
import channelpopularity.state.factory.SimpleStateFactoryI;
import channelpopularity.state.StateName;
import channelpopularity.state.StateI;
import channelpopularity.util.VideoProperties;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class ChannelContext implements ContextI, StateI {
    private StateI curState;
    private Map<StateName, StateI> availableStates;
    private Map<String, VideoProperties> videoData;


    public ChannelContext(SimpleStateFactoryI stateFactoryIn, List<StateName> stateNames) {
    // initialize states using factory instance and the provided state names.
    // initialize current state.
    availableStates = new HashMap<StateName, StateI>();
    videoData = new HashMap<String, VideoProperties>();

        for(StateName state : stateNames) {
            availableStates.put(state, stateFactoryIn.create(state, this));
        }
    }

    // Called by the States based on their logic of what the machine state should change to.
    public void setCurrentState(StateName nextState) {
        if (availableStates.containsKey(nextState)) { // for safety.
            curState = availableStates.get(nextState);
        }
    }

    public void setVideoData(String vName, VideoProperties vp){
        videoData.put(vName, vp);
        System.out.println("\n videos hashmap "+ videoData);
    }

    public Map<String, VideoProperties> getVideoData(){
        return videoData;
    }

    public void addVideo(String vName){
        curState.addVideo(vName);
    }
    public void removeVideo(){
        curState.removeVideo();
    }
    public void adRequest(){
        curState.adRequest();
    }
    public void metrics(){
        curState.metrics();
    }


    public void accessMap(int v, int l, int d)
    {
        

    }


}