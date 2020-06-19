package channelpopularity.context;
import channelpopularity.state.StateI;
import channelpopularity.state.StateName;

public class ChannelContext implements ContextI {
    private StateI curState;
    private Map<StateName, StateI> availableStates;
    public ChannelContext(SimpleStateFactoryI stateFactoryIn, List<StateName> stateNames) {
    // initialize states using factory instance and the provided state names.
    // initialize current state.
        for(StateName state : stateNames){
            availableStates.put(state, stateFactoryIn.create(state))
        }

    }

    // Called by the States based on their logic of what the machine state should change to.
    public void setCurrentState(StateName nextState) {
    if (availableStates.containsKey(nextState)) { // for safety.
        curState = availableStates.get(nextState);
    }
    }
}