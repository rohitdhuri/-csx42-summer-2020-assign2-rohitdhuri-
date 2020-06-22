package channelpopularity.state.factory;

import channelpopularity.state.StateName;
import channelpopularity.util.data.VideoData;
import channelpopularity.context.ContextI;

import channelpopularity.state.StateI;

public interface SimpleStateFactoryI {

    public StateI create(StateName state);
}
