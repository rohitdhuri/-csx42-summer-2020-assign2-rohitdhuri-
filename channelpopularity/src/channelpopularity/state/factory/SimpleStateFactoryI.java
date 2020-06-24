package channelpopularity.state.factory;

import channelpopularity.state.StateName;
import channelpopularity.state.StateI;

public interface SimpleStateFactoryI {

/**
     * SimpleStateFactory is an interface to SimpleStateFactory class which is used to create state objects
     * 
     * @author - Rohit Mahendra Dhuri
     */


    /**
     * Instatiates and returns the object a sate
     * 
     * @param - StateName of which an instiatiated object is to be returned
     */
    public StateI create(StateName state);
}
